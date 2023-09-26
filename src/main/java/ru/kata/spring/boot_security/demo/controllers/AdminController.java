package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kata.spring.boot_security.demo.repositoryes.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.entityes.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;


    @GetMapping()
    public String PrintAllUsers(Model model) {
        model.addAttribute("user", userService.allUsers());
        return "all-users";
    }


    @GetMapping("/new")
    public ModelAndView newUser() {
        ModelAndView mav = new ModelAndView("new");
        mav.addObject("person", new User());
        List<Role> roles = (List<Role>) roleRepository.findAll();
        mav.addObject("allRoles", roles);
        return mav;
    }

    @PostMapping()
    public String create(@ModelAttribute("person") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("person", userService.findUserById(id));
        model.addAttribute("allRoles", roleRepository.findAll());
        return "edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("person") User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
