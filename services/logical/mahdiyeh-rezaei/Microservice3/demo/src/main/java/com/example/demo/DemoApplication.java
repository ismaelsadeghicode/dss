package com.example.demo;

import com.example.demo.domain.Person;
import com.example.demo.repository.PersonRepository;
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
        personRepository.save(new Person().setName("Hosseinam").setFamily("Khan").setCode("001"));
        personRepository.save(new Person().setName("Mahdiyeh").setFamily("Khanoom").setCode("002"));
    }
}
