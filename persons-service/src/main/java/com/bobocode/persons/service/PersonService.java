package com.bobocode.persons.service;

import com.bobocode.persons.client.NotesClient;
import com.bobocode.persons.domain.Person;
import com.bobocode.persons.dto.NoteDto;
import com.bobocode.persons.dto.PersonDto;
import com.bobocode.persons.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    //private final DiscoveryClient discoveryClient;
    //private final RestTemplate restTemplate;
    private final NotesClient notesClient;

    public PersonDto getWithNotesById(Long personId) {
        Person person = personRepository.findById(personId).orElseThrow();
        //List<ServiceInstance> instances = discoveryClient.getInstances("notes");
        //ServiceInstance instance = instances.get(0);
        List<NoteDto> notes = notesClient.getNoteByPersonId(personId);
        return new PersonDto(person.getFirstName(), person.getLastName(), notes);
    }
}
