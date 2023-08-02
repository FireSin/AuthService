package ru.firesin.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.firesin.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
