package com.dss.sales.model;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.Objects;

@Entity
@Table(name = "Users")
public class Users {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public boolean isFemale() {
        return isFemale;
    }

    public void setFemale(boolean female) {
        isFemale = female;
    }


    @Column(name = "USERNAME")
    @Null
    private String username;

    @Column(name = "PASSWORD")
    @NonNull
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID",unique = true)
    @NonNull
    private int id;

    @Column(name = "PHONE_NUMBER")
    @Null
    private String phoneNumber;

    @Column(name = "EMAIL",nullable = true)
    @NonNull
    private String emailAdress;

    @Column(name = "MALE",nullable = true)
    @Null
    private boolean isMale;

    @Column(name = "FEMALE", nullable = true)
    @Null
    private boolean isFemale;

    @Column(name="Wallet")
    @Null
    private long wallet;


    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", phoneNumber=" + phoneNumber +
                ", emailAdress='" + emailAdress + '\'' +
                ", isMale=" + isMale +
                ", isFemale=" + isFemale +
                ", wallet=" + wallet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id &&
                phoneNumber == users.phoneNumber &&
                isMale == users.isMale &&
                isFemale == users.isFemale &&
                wallet == users.wallet &&
                Objects.equals(username, users.username) &&
                Objects.equals(password, users.password) &&
                Objects.equals(emailAdress, users.emailAdress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, id, phoneNumber, emailAdress, isMale, isFemale, wallet);
    }

    public long getWallet() {
        return wallet;
    }

    public void setWallet(long wallet) {
        this.wallet = wallet;
    }
}
