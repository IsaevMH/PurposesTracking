package org.purposetracking.controller;

import org.purposetracking.model.User;
import org.purposetracking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String showUsers(ModelMap model) {
        Iterable<User> users = userService.getAll();
        model.put("users", users);
        return "users-page";
    }

    @GetMapping("/remove-user/{id}")
    public String deleteUser(@PathVariable long id, ModelMap model) {
        User user = userService.get(id);
        if(user != null)
            userService.delete(user);
        return showUsers(model);
    }

    @GetMapping("/user-modification/{id}")
    public String showModificationForm(@PathVariable long id, ModelMap model) {
        User user = userService.get(id);
        model.put("user", user);
        return "/user-modification";
    }

    @PostMapping("/user-modification")
    public String modifyUser(@ModelAttribute User user, ModelMap model) {
        model.put("user", user);
        userService.update(user);
        return showUsers(model);
    }

    @GetMapping("/user-creation")
    public String showRegistrationForm(ModelMap model) {
        User user = new User();
        model.put("user", user);
        return "/user-creation";
    }

    @PostMapping("/user-creation")
    public String createUser(@ModelAttribute User user, ModelMap model) {
        model.addAttribute("user", user);
        userService.save(user);
        return showUsers(model);
    }

    @GetMapping("/user-profile/{id}")
    public String showUserProfile(@PathVariable long id, ModelMap model) {
        User user = userService.get(id);
        model.put("user", user);
        return "/user-profile";
    }
}
