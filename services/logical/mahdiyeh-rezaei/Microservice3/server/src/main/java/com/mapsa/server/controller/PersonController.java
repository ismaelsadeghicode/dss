package com.mapsa.server.controller;

import com.mapsa.server.domain.Person;
import com.mapsa.server.repository.PersonRepository;
import com.mapsa.server.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    PersonRepository personRepository;
    PersonService personService;

    @Autowired
    public PersonController(PersonRepository personRepository, PersonService personService) {
        this.personRepository = personRepository;
        this.personService = personService;
    }

    @GetMapping
    public List<Person> findAllPeople() {
        return personRepository.findAll();
    }

    @GetMapping("name/{name}")
    public Person findByName(@PathVariable String name) {
        return personRepository.findByName(name);
    }

    @GetMapping("family/{family}")
    public Person findByFamily(@PathVariable String family) {
        return personRepository.findByFamily(family);
    }

    @GetMapping("code/{code}")
    public Person findByCode(@PathVariable String code) {
        return personRepository.findByNationalCode(code);
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        return ResponseEntity.ok().body(personService.savePerson(person));
    }
}
