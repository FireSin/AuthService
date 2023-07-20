package ru.firesin.auth.dto.request;

import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String password;
}
