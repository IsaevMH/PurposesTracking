package org.purposetracking.repository;

import org.purposetracking.model.Purpose;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurposeRepository extends CrudRepository<Purpose, Long> {
    //List<Purpose> findAllPurposesByName(String name);
    Purpose findPurposeById(Long id);

}
