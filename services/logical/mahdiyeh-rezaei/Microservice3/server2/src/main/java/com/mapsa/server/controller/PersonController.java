package com.mapsa.server.controller;

import com.mapsa.server.domain.Person;
import com.mapsa.server.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {
    PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public List<Person> findAllPeople(){
        return personRepository.findAll();
    }

    @GetMapping("code/{code}")
    public Person findByNationalCode(@PathVariable String code){
        return personRepository.findByNationalCode(code);
    }


}
