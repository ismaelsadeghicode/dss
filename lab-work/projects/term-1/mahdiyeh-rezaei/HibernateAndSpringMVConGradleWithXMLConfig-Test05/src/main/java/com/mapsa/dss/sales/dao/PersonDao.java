package com.mapsa.dss.sales.dao;

import com.mapsa.dss.sales.model.Person;

import java.util.List;

public interface PersonDao {
    List<Person> findAllPersons();
    Person getPersonById(int id);
    Person getPersonByUsername(String username);
    void insertPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(Person person);
}
