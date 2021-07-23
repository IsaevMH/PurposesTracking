package org.purposetracking.service;

import org.purposetracking.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements RootService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(Object object) {

    }

    @Override
    public void update(Object object) {

    }

    @Override
    public void delete(Object object) {

    }

    @Override
    public Object get(long id) {
        return null;
    }

    @Override
    public Iterable getAll() {
        return categoryRepository.findAll();
    }
}
