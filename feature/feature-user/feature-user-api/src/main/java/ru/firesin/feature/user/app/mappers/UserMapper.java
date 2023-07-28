package ru.firesin.feature.user.app.mappers;

import org.mapstruct.Mapper;
import ru.firesin.feature.user.app.dtoUser.request.UserDTO;
import ru.firesin.feature.user.app.entity.User;
import ru.firesin.tokens.dto.TokenDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

    TokenDTO toUserDTO(User user);

    User toUser(UserDTO userDTO);
}
