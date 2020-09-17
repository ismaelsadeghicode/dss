package com.mapsa.dss.demo;

import com.mapsa.dss.demo.domain.Person;
import com.mapsa.dss.demo.repository.PersonRepository;
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
        for (int i = 0; i < 100; i+=2) {
            personRepository.save(Person.builder()
                    .id(0)
                    .name("maryam" + (i-1))
                    .family("maryami" + i + "_")
                    .mobile("09308150939" + i)
                    .build());
            personRepository.save(Person.builder()
                    .id(0)
                    .name("mahdiyeh" + i + i)
                    .family("Rezaei" + "__" + i)
                    .mobile("09123456789" + (i + i))
                    .build());
        }
    }
}
