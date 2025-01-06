package com.Abood.Project.Repository;

import com.Abood.Project.Entity.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface WebsiteRepository extends JpaRepository<Website, String> {
    // Find a Website page by name
    Optional<Website> findByPageName(String pageName);

    // Find all Website pages updated after a specific date
    List<Website> findByLastUpdatedAfter(LocalDateTime date);

    // Count the number of Website pages
    long count();

    // Delete a Website page by ID
    void deleteByPageID(String pageID);
}
