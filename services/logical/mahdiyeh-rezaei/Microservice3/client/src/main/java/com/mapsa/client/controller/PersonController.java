package com.mapsa.client.controller;

import com.mapsa.client.client.PersonServiceClient;
import com.mapsa.client.domain.Person;
import com.mapsa.client.dto.PersonDTO;
import com.mapsa.client.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
public class PersonController {
    @Autowired
    PersonServiceClient personServiceClient;

    @Autowired
    PersonRepository personRepository;

    @GetMapping("{code}")
    public PersonDTO personDTO(@PathVariable String code) {
        return personServiceClient.findPerson(code);
    }

    @PostMapping
    public Person savePerson(@RequestBody Person person) {
        PersonDTO personDTO = personServiceClient.findPerson(person.getNationalCode());
        person.setName(personDTO.getName());
        person.setFamily(personDTO.getFamily());
        return personRepository.save(person);
    }
}
