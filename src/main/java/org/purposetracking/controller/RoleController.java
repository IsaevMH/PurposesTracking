package org.purposetracking.controller;

import org.purposetracking.model.Role;
import org.purposetracking.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/role/all")
    public String showRoles(ModelMap map) {
        List<Role> roles = roleService.getAll();
        map.put("roles", roles);
        return "/role/all";
    }

    @GetMapping("/role/new")
    public String showCtreationForm(ModelMap map) {
        Role role = new Role();
        map.put("role", role);
        return "/role/new";
    }

    @PostMapping("/role/new")
    public String createRole(Role role, ModelMap map) {
        roleService.save(role);
        map.put("role", role);
        return showRoles(map);
    }

    @GetMapping("/role/modify/{id}")
    public String showModificationForm(@PathVariable long id, ModelMap map) {
        Role role = roleService.get(id);
        map.put("role", role);
        return "/role/modify";
    }

    @PostMapping("/role/modify")
    public String modifyRoles(@ModelAttribute Role role, ModelMap map) {
        roleService.save(role);
        map.put("role", role);
        return showRoles(map);
    }

    @GetMapping("/role/remove/{id}")
    public String removeRole(@PathVariable long id, ModelMap map) {
        Role role = roleService.get(id);
        roleService.delete(role);
        map.put("role", role);
        return showRoles(map);
    }
}
