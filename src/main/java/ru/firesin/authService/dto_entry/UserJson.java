package ru.firesin.authService.dto_entry;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class UserJson {
    private String name;
    private String password;
}
