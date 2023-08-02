package ru.firesin.user.dtoUser.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private String name;
    private String password;
}
