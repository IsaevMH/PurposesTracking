package org.purposetracking.repository;

import org.purposetracking.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    //List<User> findAllUsersByName(String userName);
    User findUserById(Long id);

}
