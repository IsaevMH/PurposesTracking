package org.purposetracking.repository;

import org.purposetracking.model.Purpose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurposeRepository extends JpaRepository<Purpose, Long> {
    public List<Purpose> getAllByUserId(long id);
}
