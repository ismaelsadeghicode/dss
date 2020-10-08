package com.mapsa.server;

import com.mapsa.server.domain.Person;
import com.mapsa.server.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Autowired
    PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        personRepository.save(new Person()
                .setName("Hossein")
                .setFamily("Seyfoori")
                .setGender("Man")
                .setAge(26)
                .setNationalCode("001"));
        personRepository.save(new Person()
                .setName("Mahdiyeh")
                .setFamily("Rezaei")
                .setGender("Woman")
                .setAge(22)
                .setNationalCode("002"));
    }
}
