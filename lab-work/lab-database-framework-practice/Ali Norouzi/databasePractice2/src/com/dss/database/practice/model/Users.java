package com.dss.database.practice.model;

import com.dss.database.practice.annotations.Column;
import com.dss.database.practice.annotations.Entity;
import com.dss.database.practice.annotations.Id;
import com.dss.database.practice.annotations.Table;

import java.util.Objects;

@Entity
@Table(
        name = "USERS"
)
public class Users {
    @Column(
            name = "USERNAME",
            dataType = "VARCHAR",
            length = 15,
            primaryKey = true
    )
    private String username;
    @Column(
            name = "PASSWORD",
            dataType = "VARCHAR",
            length = 20
    )
    private String password;
    @Column(
            name = "PHONENUMBER",
            dataType = "NUMBER",
            length = 13
    )
    private long phoneNumber;
    @Id
    @Column(
            name = "ID",
            dataType = "NUMBER",
            length = 15,
            unique = true
    )
    private long id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Users users = (Users) object;
        return phoneNumber == users.phoneNumber &&
                id == users.id &&
                Objects.equals(username, users.username) &&
                Objects.equals(password, users.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, phoneNumber, id);
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", id=" + id +
                '}';
    }
}
