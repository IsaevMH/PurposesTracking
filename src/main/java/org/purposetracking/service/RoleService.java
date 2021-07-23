package org.purposetracking.service;

import org.purposetracking.model.Role;
import org.purposetracking.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements RootService<Role> {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void update(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public Role get(long id) {
        return roleRepository.getById(id);
    }

    @Override
    public Iterable<Role> getAll() {
        return roleRepository.findAll();
    }
}
