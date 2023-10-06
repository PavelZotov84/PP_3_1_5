package ru.kata.spring.boot_security.demo.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ru.kata.spring.boot_security.demo.entityes.*;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;


import java.util.HashSet;
import java.util.Set;

@Component
public class CreateUsers implements CommandLineRunner {
    private final UserService userService;
    private final RoleService roleService;

    public CreateUsers(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {

//        // логин = user пароль = user
        User user1 = new User("user", "user", 10, "user", "user");
//        // логин = admin@mail.ru пароль = admin
        User admin1 = new User("admin@mail.ru", "admin", 26, "admin", "admin");
        Set<Role> roleTwo = new HashSet<>();
        roleTwo.add(new Role((long) 2, "ROLE_ADMIN"));
        Set<Role> roleOne = new HashSet<>();
        roleOne.add(new Role((long) 1, "ROLE_USER"));
        roleService.addRole(new Role((long) 1, "ROLE_USER"));
        roleService.addRole(new Role((long) 2, "ROLE_ADMIN"));
        user1.setRoles(roleOne);
        admin1.setRoles(roleTwo);
        userService.addUser(user1);
        userService.addUser(admin1);
    }
}