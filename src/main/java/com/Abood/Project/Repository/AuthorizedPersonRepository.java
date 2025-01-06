package com.Abood.Project.Repository;

import com.Abood.Project.Entity.AuthorizedPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface AuthorizedPersonRepository extends JpaRepository<AuthorizedPerson, Long> {
    // Find all AuthorizedPersons added after a specific date
    List<AuthorizedPerson> findByAddedAtAfter(LocalDateTime date);

    // Find AuthorizedPersons by name (case-insensitive)
    List<AuthorizedPerson> findByNameIgnoreCase(String name);

    // Count the number of AuthorizedPersons
    long count();

    // Delete an AuthorizedPerson by ID
    void deleteByAuthorizedID(Long authorizedID);
}
