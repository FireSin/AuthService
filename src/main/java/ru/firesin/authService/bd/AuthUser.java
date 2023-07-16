package ru.firesin.authService.bd;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Data
@NoArgsConstructor
@Entity(name = "authuser")
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Name is required")
    @Column(nullable = false, unique = true)
    private String name;
    @NotBlank(message = "Password is required")
    @Column(nullable = false)
    private String password;
    private String role;
    private String token;
}
