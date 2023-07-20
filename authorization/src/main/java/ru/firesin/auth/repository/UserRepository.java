package ru.firesin.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.firesin.auth.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByToken(String token); //TODO Зачем?
    User findByName(String name);
}
