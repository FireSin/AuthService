package ru.firesin.user.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.firesin.user.dtoUser.request.UserDTO;
import ru.firesin.user.entity.User;
import ru.firesin.tokens.dto.TokenDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "role", source = "role")
    TokenDTO toUserDTO(User user);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "password", source = "password")
    User toUser(UserDTO userDTO);
}
