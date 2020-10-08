package com.mapsa.demo.controller;

import com.mapsa.demo.domain.Person;
import com.mapsa.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        return ResponseEntity.ok(person);
    }

    @GetMapping("/all/{page}")
    public ResponseEntity<List<Person>> listResponseEntity(@PathVariable int page) {
        return ResponseEntity.ok(personRepository.findAll(PageRequest.of(page, 10)).getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable int id) {
        return ResponseEntity.ok(personRepository.findById(id).orElse(new Person()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable int id, @RequestBody Person person) {
        Person person1 = personRepository.findById(id).get();
        if (person1 == null) {
            throw new PersonNotfoundException();
        }
        person1.setName(person.getName());
        person1.setMobile(person.getMobile());
        return ResponseEntity.ok(personRepository.save(person1));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        if (id > 100) {
            throw new PersonNotfoundException();
        }
        personRepository.deleteById(id);
    }

}
