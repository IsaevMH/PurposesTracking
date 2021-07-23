package org.purposetracking.controller;

import org.purposetracking.model.Category;
import org.purposetracking.model.Purpose;
import org.purposetracking.model.User;
import org.purposetracking.service.CategoryService;
import org.purposetracking.service.PurposeService;
import org.purposetracking.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@Controller()
public class PurposeController {

    private final PurposeService purposeService;
    private final UserService userService;
    private final CategoryService categoryService;

    public PurposeController(PurposeService purposeService, UserService userService, CategoryService categoryService) {
        this.purposeService = purposeService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @GetMapping("/purpose/all")
    public String showPurposes(ModelMap model) {
        Iterable<Purpose> purposes = purposeService.getAll();
        model.put("purposes", purposes);
        return "/purpose/all";
    }

    @GetMapping("/purpose/modify/{id}")
    public String showModificationForm(@PathVariable long id, ModelMap model) {
        Purpose purpose = purposeService.get(id);
        Iterable<User> users = userService.getAll();
        Iterable<Category> categories = categoryService.getAll();
        model.put("categories", categories);
        model.put("users", users);
        model.put("purpose", purpose);
        return "/purpose/modify";
    }

    @PostMapping("/purpose/modify")
    public String modifyPurpose(@ModelAttribute Purpose purpose, ModelMap model) {
        model.put("purpose", purpose);
        purposeService.update(purpose);
        return showPurposes(model);
    }

    @GetMapping("/purpose/new")
    public String showRegistrationForm(ModelMap model) {
        Purpose purpose = new Purpose();
        purpose.setDateOfCreation(LocalDateTime.now());
        Iterable<User> users = userService.getAll();
        Iterable<Category> categories = categoryService.getAll();
        model.put("categories", categories);
        model.put("users", users);
        model.put("purpose", purpose);
        return "/purpose/new";
    }

    @PostMapping("/purpose/new")
    public String createUser(@ModelAttribute Purpose purpose, @ModelAttribute User user, ModelMap model) {
        model.addAttribute("purpose", purpose);
        model.addAttribute("user", user);
        purposeService.save(purpose);
        return showPurposes(model);
    }

    @GetMapping("/purpose/remove/{id}")
    public String deleteUser(@PathVariable long id, ModelMap model) {
        Purpose user = purposeService.get(id);
        if(user != null)
            purposeService.delete(user);
        return showPurposes(model);
    }
}
