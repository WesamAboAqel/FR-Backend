package com.Abood.Project.Service;

import com.Abood.Project.Entity.AuthorizedPerson;
import com.Abood.Project.Repository.AuthorizedPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorizedPersonService {

    @Autowired
    private AuthorizedPersonRepository repository;

    public List<AuthorizedPerson> getAllAuthorizedPersons() {
        return repository.findAll();
    }

    public Optional<AuthorizedPerson> getAuthorizedPersonById(Long id) {
        return repository.findById(id);
    }

    public AuthorizedPerson saveAuthorizedPerson(AuthorizedPerson person) {
        return repository.save(person);
    }

    public void deleteAuthorizedPerson(Long id) {
        repository.deleteByAuthorizedID(id);
    }

    public List<AuthorizedPerson> getAuthorizedPersonsAddedAfter(LocalDateTime date) {
        return repository.findByAddedAtAfter(date);
    }

    public List<AuthorizedPerson> searchAuthorizedPersonsByName(String name) {
        return repository.findByNameIgnoreCase(name);
    }

    public List<String> getAllAuthorizedNames() {
        return repository.findAll()
            .stream()
            .map(AuthorizedPerson::getName)
            .collect(Collectors.toList());
    }
}
