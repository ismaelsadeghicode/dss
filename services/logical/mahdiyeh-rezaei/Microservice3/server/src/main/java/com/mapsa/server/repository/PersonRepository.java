package com.mapsa.server.repository;

import com.mapsa.server.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByName(String name);

    Person findByFamily(String family);

    Person findByNationalCode(String code);
}
