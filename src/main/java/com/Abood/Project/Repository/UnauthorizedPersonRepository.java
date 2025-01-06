package com.Abood.Project.Repository;

import com.Abood.Project.Entity.UnauthorizedPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface UnauthorizedPersonRepository extends JpaRepository<UnauthorizedPerson, Long> {
    // Find all UnauthorizedPersons detected before a specific date
    List<UnauthorizedPerson> findByDetectedAtBefore(LocalDateTime date);

    // Find UnauthorizedPersons by name containing a keyword
    List<UnauthorizedPerson> findByNameContainingIgnoreCase(String keyword);

    // Count the number of UnauthorizedPersons
    long count();

    // Delete an UnauthorizedPerson by ID
    void deleteByUnauthorizedID(Long unauthorizedID);
}
