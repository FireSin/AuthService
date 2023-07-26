package ru.firesin.auth.mappers;

import org.mapstruct.Mapper;
import ru.firesin.auth.dto.request.UserDTO;
import ru.firesin.auth.entity.User;
import ru.firesin.tokens.dto.TokenDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

    TokenDTO toUserDTO(User user);

    User toUser(UserDTO userDTO);
}
