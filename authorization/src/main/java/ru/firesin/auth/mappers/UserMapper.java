package ru.firesin.auth.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.firesin.auth.entity.User;
import ru.firesin.tokens.dto.TokenUserDTO;

@Mapper
public interface UserMapper {

    UserMapper INSTANSE = Mappers.getMapper(UserMapper.class); //TODO Поищи как можно по другому

    TokenUserDTO toTokenUserDTO(User user);
}
