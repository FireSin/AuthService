package ru.firesin.auth.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.firesin.auth.dto.request.UserDTO;
import ru.firesin.auth.entity.User;
import ru.firesin.auth.exceptions.AuthorizeException;
import ru.firesin.auth.exceptions.UserNotFoundException;
import ru.firesin.auth.repository.UserRepository;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findUser(UserDTO userDTO) {
        checkUserDTO(userDTO);
        User user = userRepository.findByName(userDTO.getName());
        if (user == null){
            throw new UserNotFoundException("User not found");
        }
        return user;
    }

    @Override
    public User saveNewUser(UserDTO userDTO, String role) {
        checkUserDTO(userDTO);
        if (userRepository.findByName(userDTO.getName()) != null){
            throw new AuthorizeException("User already exists"); //TODO почему Authorize при save?
        }
        User user = new User(); //TODO почему не маппер используешь?
        user.setName(userDTO.getName());
        user.setPassword(PasswordService.hashPassword(userDTO.getPassword()));
        user.setRole(role);
        userRepository.save(user);
        return user;
    }

    @Override
    public User saveNewUser(UserDTO user) {
        return saveNewUser(user, "localUser");
    }

    private void checkUserDTO(UserDTO userDTO){
        if (userDTO.getName() == null || userDTO.getName().isEmpty()
            || userDTO.getPassword() == null || userDTO.getPassword().isEmpty()){
            throw new AuthorizeException("Username or password is empty");
        }
    }
}
