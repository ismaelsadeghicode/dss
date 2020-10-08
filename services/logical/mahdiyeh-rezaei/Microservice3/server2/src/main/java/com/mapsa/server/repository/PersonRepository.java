package com.mapsa.server.repository;

import com.mapsa.server.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {
    Person findByNationalCode(String code);
}
