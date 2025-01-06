package com.Abood.Project.Service;

import com.Abood.Project.Entity.Website;
import com.Abood.Project.Repository.WebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class WebsiteService {

    @Autowired
    private WebsiteRepository repository;

    public List<Website> getAllPages() {
        return repository.findAll();
    }

    public Optional<Website> findPageByName(String name) {
        return repository.findByPageName(name);
    }

    public Website savePage(Website page) {
        return repository.save(page);
    }

    public void deletePage(String id) {
        repository.deleteByPageID(id);
    }

    public List<Website> findPagesUpdatedAfter(LocalDateTime date) {
        return repository.findByLastUpdatedAfter(date);
    }
}
