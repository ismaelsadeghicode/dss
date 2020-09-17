package com.mapsa.dss.demo.repository;

import com.mapsa.dss.demo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByName(String name);
    Person findByFamily(String family);
    Person findByMobile(String mobile);
}
