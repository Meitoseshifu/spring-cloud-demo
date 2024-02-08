package com.bobocode.persons.controller;

import com.bobocode.persons.domain.Person;
import com.bobocode.persons.dto.PersonDto;
import com.bobocode.persons.repository.PersonRepository;
import com.bobocode.persons.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;
    private final PersonService personService;

    @GetMapping
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @GetMapping("/{personId}")
    public PersonDto getPersonWithNotes(@PathVariable Long personId) {
        return personService.getWithNotesById(personId);
    }
}
