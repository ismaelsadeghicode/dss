package com.mapsa.model;

import com.mapsa.persistance.Column;
import com.mapsa.persistance.Entity;
import com.mapsa.persistance.Id;
import com.mapsa.persistance.Table;

import java.lang.annotation.Target;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMER",schema = "FQX")
public class Customer {
    @Id
    @Column(name = "ID",dataType = "VARCHAR" ,length = 40)
    private int id;
    @Column(name = "firstname",dataType = "VARCHAR",length = 50)
    private String firstName;
    @Column(name = "lastname",dataType = "VARCHAR",length = 50)
    private String lastName;

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName);
    }

}
