package ru.firesin.feature.user.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.firesin.feature.password.api.PasswordService;
import ru.firesin.feature.user.app.UserService;
import ru.firesin.feature.user.app.dtoUser.request.UserDTO;
import ru.firesin.feature.user.app.entity.User;
import ru.firesin.feature.user.app.mappers.UserMapper;
import ru.firesin.feature.user.app.repository.UserRepository;
import ru.firesin.feature.user.impl.exceptions.UserServiceException;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordService passwordService;
    private final UserMapper userMapper;

    @Override
    public User findUser(UserDTO userDTO) {
        checkUserDTO(userDTO);
        User user = userRepository.findByName(userDTO.getName());
        if (user == null){
            throw new UserServiceException("User not found");
        }
        return user;
    }

    @Override
    public User saveNewUser(UserDTO userDTO, String role) {
        checkUserDTO(userDTO);
        if (userRepository.findByName(userDTO.getName()) != null){
            throw new UserServiceException("User already exists");
        }
        User user = userMapper.toUser(userDTO);
        user.setPassword(passwordService.hashPassword(userDTO.getPassword()));
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
            throw new UserServiceException("Username or password is empty");
        }
    }
}
