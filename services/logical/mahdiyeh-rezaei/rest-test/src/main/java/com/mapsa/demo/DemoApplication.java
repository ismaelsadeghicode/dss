package com.mapsa.demo;

import com.mapsa.demo.domain.Person;
import com.mapsa.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 100; i++) {
            personRepository.save(Person.builder().id(0).name("mahdiyeh" + i).mobile("091" + i).build());
        }
    }
}
