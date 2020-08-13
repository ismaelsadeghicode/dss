package com.mapsa.dss.sales.model;

import com.mapsa.dss.sales.persistence.Id;
import com.mapsa.dss.sales.persistence.Table;
import com.mapsa.dss.sales.persistence.Column;
import com.mapsa.dss.sales.persistence.Entity;

import java.util.Objects;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @Column(name = "person_id", dataType = "NUMBER", length = 10)
    private int person_id;
    @Column(name = "first_name", dataType = "VARCHAR", length = 30)
    private String firstName;
    @Column(name = "last_name", dataType = "VARCHAR", length = 30)
    private String lastName;
    @Column(name = "password", dataType = "VARCHAR", length = 6)
    private String password;

    public Person() {}

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return person_id == person.person_id &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person_id, firstName, lastName, password);
    }

    @Override
    public String toString() {
        return "Person{" +
                "person_id=" + person_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
