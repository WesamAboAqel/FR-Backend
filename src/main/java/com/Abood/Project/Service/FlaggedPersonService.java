package com.Abood.Project.Service;

import com.Abood.Project.Entity.FlaggedPerson;
import com.Abood.Project.Repository.FlaggedPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlaggedPersonService {

    @Autowired
    private FlaggedPersonRepository repository;

    public List<FlaggedPerson> getAllFlaggedPersons() {
        return repository.findAll();
    }

    public FlaggedPerson saveFlaggedPerson(FlaggedPerson person) {
        return repository.save(person);
    }

    public void deleteFlaggedPerson(Long id) {
        repository.deleteByFlaggedID(id);
    }


    public List<FlaggedPerson> findFlaggedPersonsAfterDate(LocalDateTime date) {
        return repository.findByFlaggedAtAfter(date);
    }

    public List<String> getAllFlaggedNames() {
        return repository.findAll()
            .stream()
            .map(FlaggedPerson::getName)
            .collect(Collectors.toList());
    }
}
