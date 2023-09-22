package ru.kata.spring.boot_security.demo.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.boot_security.demo.entityes.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
