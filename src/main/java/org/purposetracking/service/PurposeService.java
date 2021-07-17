package org.purposetracking.service;

import org.purposetracking.model.Purpose;
import org.purposetracking.repository.PurposeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PurposeService implements RootService<Purpose> {

    @Autowired
    private PurposeRepository purposeRepository;

    @Override
    public void save(Purpose purpose) {
        purposeRepository.save(purpose);
    }

    @Override
    public void update(Purpose purpose) {
        purposeRepository.save(purpose);
    }

    @Override
    public void delete(Purpose purpose) {
        purposeRepository.delete(purpose);
    }

    @Override
    public Purpose get(long id) {
        return purposeRepository.getById(id);
    }

    @Override
    public Iterable<Purpose> getAll() {
        return purposeRepository.findAll();
    }
}
