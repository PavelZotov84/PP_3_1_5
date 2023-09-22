package ru.kata.spring.boot_security.demo.repositoryes;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.boot_security.demo.entityes.*;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
