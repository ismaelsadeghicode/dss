package com.example.demo.controller;

import com.example.demo.domain.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {
    PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping()
    public List<Person> personList() {
        return personRepository.findAll();
    }

    @GetMapping("{code}")
    public Person findByCode(@PathVariable String code) {
        return personRepository.findByCode(code);
    }
}
