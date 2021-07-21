package org.purposetracking.service;

import org.purposetracking.model.Role;
import org.purposetracking.model.User;
import org.purposetracking.repository.RoleRepository;
import org.purposetracking.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements RootService<User>{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void save(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.getById(2L));
        user.setRoles(roles);
        user.setActivate(true);
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        Set<Role> roles = user.getRoles();
        user.setRoles(roles);
        user.setActivate(true);
        userRepository.saveAndFlush(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User get(long id) {
        return userRepository.getById(id);
    }

    @Override
    public Iterable<User> getAll() { return userRepository.findAll();}
}
