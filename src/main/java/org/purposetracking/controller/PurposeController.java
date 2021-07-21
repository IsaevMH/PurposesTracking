package org.purposetracking.controller;

import org.purposetracking.model.Purpose;
import org.purposetracking.model.User;
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

    public PurposeController(PurposeService purposeService, UserService userService) {
        this.purposeService = purposeService;
        this.userService = userService;
    }

    @GetMapping("/purposes")
    public String showPurposes(ModelMap model) {
        Iterable<Purpose> purposes = purposeService.getAll();
        model.put("purposes", purposes);
        return "purposes-page";
    }

    @GetMapping("/purpose-modification/{id}")
    public String showModificationForm(@PathVariable long id, ModelMap model) {
        Purpose purpose = purposeService.get(id);
        Iterable<User> users = userService.getAll();
        model.put("users", users);
        model.put("purpose", purpose);
        return "/purpose-modification";
    }

    @PostMapping("/purpose-modification")
    public String modifyPurpose(@ModelAttribute Purpose purpose, ModelMap model) {
        model.put("purpose", purpose);
        purposeService.update(purpose);
        return showPurposes(model);
    }

    @GetMapping("/purpose-creation")
    public String showRegistrationForm(ModelMap model) {
        Purpose purpose = new Purpose();
        purpose.setDateOfCreation(LocalDateTime.now());
        Iterable<User> users = userService.getAll();
        model.put("users", users);
        model.put("purpose", purpose);
        return "/purpose-creation";
    }

    @PostMapping("/purpose-creation")
    public String createUser(@ModelAttribute Purpose purpose, @ModelAttribute User user, ModelMap model) {
        model.addAttribute("purpose", purpose);
        model.addAttribute("user", user);
        purposeService.save(purpose);
        return showPurposes(model);
    }

    @GetMapping("/purpose-remove/{id}")
    public String deleteUser(@PathVariable long id, ModelMap model) {
        Purpose user = purposeService.get(id);
        if(user != null)
            purposeService.delete(user);
        return showPurposes(model);
    }
}
