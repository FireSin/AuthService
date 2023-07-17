package ru.firesin.auth.dto.request;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class UserDTO {
    private String name;
    private String password;
}
