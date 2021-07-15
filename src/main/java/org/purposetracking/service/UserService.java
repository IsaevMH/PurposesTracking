package org.purposetracking.service;

import org.purposetracking.model.User;
import org.purposetracking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements RootService<User> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
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
    public Iterable<User> getAll(String userName) {
        //return userRepository.findAllUsersByName(userName);
        return null;
    }

    @Override
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }
}
