package org.purposetracking.service;

import org.purposetracking.model.Purpose;
import org.purposetracking.repository.PurposeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurposeService implements RootService<Purpose> {

    private final PurposeRepository purposeRepository;

    public PurposeService(PurposeRepository purposeRepository) {
        this.purposeRepository = purposeRepository;
    }

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
    public List<Purpose> getAll() {
        return purposeRepository.findAll();
    }
}
