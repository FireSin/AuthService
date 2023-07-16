package ru.firesin.authService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.firesin.authService.bd.AuthUser;

@Repository
public interface UserRepository extends JpaRepository<AuthUser, Long> {
    AuthUser findByToken(String token);
}
