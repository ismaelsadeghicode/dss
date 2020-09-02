package com.mapsa.dss.sales.dao;

import com.mapsa.dss.sales.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Repository
@Transactional
public class PersonDaoImpl implements PersonDao {

    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<Person> findAllPersons() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Person order by id");
        List<Person> personList = query.list();
        session.flush();
        return personList;
    }

    @Override
    public Person getPersonById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person person = session.get(Person.class,id);
        session.flush();
        return person;
    }

    @Override
    public Person getPersonByUsername(String username) {
        //TODO
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Person p WHERE p.username  = :username");
        query.setParameter("username",username);
        session.flush();
        return (Person) query.uniqueResult();
    }

    @Override
    public void insertPerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
        session.flush();
    }

    @Override
    public void updatePerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.update(person);
        session.flush();
    }

    @Override
    public void deletePerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(person);
        session.flush();
    }
}
