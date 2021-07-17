package org.purposetracking.service;

import org.purposetracking.model.Role;
import org.purposetracking.model.User;
import org.purposetracking.repository.RoleRepository;
import org.purposetracking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements RootService<User>{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void save(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.getById(2L));
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User get(long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public Iterable<User> getAll() { return userRepository.findAll();}
}
