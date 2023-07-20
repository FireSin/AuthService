package ru.firesin.auth.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@NoArgsConstructor
@Table(name = "my_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(name = "Name", nullable = false, unique = true)
    private String name;

    @NotBlank(message = "Password is required")
    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Role")
    private String role;
}
