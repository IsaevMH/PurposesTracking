package org.purposetracking.service;

public interface RootService<T> {
    void save(T object);
    void update(T object);
    void delete(T object);
    T get(long id);
    Iterable<T> getAll();
}
