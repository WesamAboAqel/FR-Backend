package com.Abood.Project.Service;

import com.Abood.Project.Entity.UnauthorizedPerson;
import com.Abood.Project.Repository.UnauthorizedPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnauthorizedPersonService {

    @Autowired
    private UnauthorizedPersonRepository repository;

    public List<UnauthorizedPerson> getAllUnauthorizedPersons() {
        return repository.findAll();
    }

    public UnauthorizedPerson saveUnauthorizedPerson(UnauthorizedPerson person) {
        return repository.save(person);
    }

    public void deleteUnauthorizedPerson(Long id) {
        repository.deleteByUnauthorizedID(id);
    }

    public List<UnauthorizedPerson> findUnauthorizedPersonsDetectedBefore(LocalDateTime date) {
        return repository.findByDetectedAtBefore(date);
    }

    public List<UnauthorizedPerson> searchUnauthorizedPersonsByName(String keyword) {
        return repository.findByNameContainingIgnoreCase(keyword);
    }

    public List<String> getAllUnauthorizedNames() {
        return repository.findAll()
            .stream()
            .map(UnauthorizedPerson::getName)
            .collect(Collectors.toList());
    }
}
