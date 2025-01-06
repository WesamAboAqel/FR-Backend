package com.Abood.Project.Repository;

import com.Abood.Project.Entity.FlaggedPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface FlaggedPersonRepository extends JpaRepository<FlaggedPerson, Long> {
    // Find FlaggedPersons flagged after a specific date
    List<FlaggedPerson> findByFlaggedAtAfter(LocalDateTime date);

    // Count the number of FlaggedPersons
    long count();

    // Delete a FlaggedPerson by ID
    void deleteByFlaggedID(Long flaggedID);
}
