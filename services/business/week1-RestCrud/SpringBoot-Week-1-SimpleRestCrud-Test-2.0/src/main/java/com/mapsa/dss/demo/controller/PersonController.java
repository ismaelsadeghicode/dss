package com.mapsa.dss.demo.controller;

import com.mapsa.dss.demo.domain.Person;
import com.mapsa.dss.demo.repository.PersonRepository;
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
    public ModelAndView login() {
        return new ModelAndView("index");
    }

    //Create
    @PostMapping("/create")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return ResponseEntity.ok(personRepository.save(person));
    }

    //Read
    @GetMapping("/list")
    public ResponseEntity<List<Person>> findAllPeople() {
        return ResponseEntity.ok(personRepository.findAll());
    }

    @GetMapping("li/{page}")
    public List<Person> showPeopleOnPage(@PathVariable int page) {
        return personRepository.findAll(PageRequest.of(page, 10)).getContent();
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Person> findPersonById(@PathVariable int id) {
        return ResponseEntity.ok(personRepository.findById(id).orElse(new Person()));
    }

    @GetMapping("name/{name}")
    public ResponseEntity<Person> findPersonByname(@PathVariable String name) {
        return ResponseEntity.ok(personRepository.findByName(name));
    }

    @GetMapping("family/{family}")
    public ResponseEntity<Person> findPersonByFamily(@PathVariable String family) {
        return ResponseEntity.ok(personRepository.findByFamily(family));
    }

    @GetMapping("mobile/{mobile}")
    public ResponseEntity<Person> findPersonByMobile(@PathVariable String mobile) {
        return ResponseEntity.ok(personRepository.findByMobile(mobile));
    }

    //Update
    @PutMapping("update/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person person) {
        Person person1 = personRepository.findById(id).get();
        if (person.getName() != null) {
            person1.setName(person.getName());
        }
        if (person.getFamily() != null) {
            person1.setFamily(person.getFamily());
        }
        if (person.getMobile() != null) {
            person1.setMobile(person.getMobile());
        }
        return ResponseEntity.ok(personRepository.save(person1));
    }

    //Delete
    @DeleteMapping("/del/{id}")
    public void deletePerson(@PathVariable int id) {
        if (id >= 100) {
            throw new PersonNotFoundException();
        }
        personRepository.deleteById(id);
    }

    @DeleteMapping("/del")
    public void deleteAll(){
        personRepository.deleteAll();
    }
}
