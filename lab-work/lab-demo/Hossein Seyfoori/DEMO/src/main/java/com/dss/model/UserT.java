package com.dss.model;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class UserT {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String phone_number;

    private String password;
    @Column(unique = true)
    private String username;
    private String email;
    private String national_code;
    private String avatar;
    private String first_name;
    private String last_name;
    private Date creation_at;
    private boolean isDeleted;
    private boolean isActive;
    @OneToMany
    List<UserTypeT> userType ;
    @OneToMany
    List<Bank> banks;
    @OneToMany
    List<LoginHisotry> loginHisotries;
    @OneToMany
    List<SmsVerification> smsVerifications;
    @OneToMany
    List<Wallet> wallets;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNational_code() {
        return national_code;
    }

    public void setNational_code(String national_code) {
        this.national_code = national_code;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getCreation_at() {
        return creation_at;
    }

    public void setCreation_at(Date creation_at) {
        this.creation_at = creation_at;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<UserTypeT> getUserType() {
        return userType;
    }

    public void setUserType(List<UserTypeT> userType) {
        this.userType = userType;
    }

    public List<Bank> getBanks() {
        return banks;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }

    public List<LoginHisotry> getLoginHisotries() {
        return loginHisotries;
    }

    public void setLoginHisotries(List<LoginHisotry> loginHisotries) {
        this.loginHisotries = loginHisotries;
    }

    public List<SmsVerification> getSmsVerifications() {
        return smsVerifications;
    }

    public void setSmsVerifications(List<SmsVerification> smsVerifications) {
        this.smsVerifications = smsVerifications;
    }

    public List<Wallet> getWallets() {
        return wallets;
    }

    public void setWallets(List<Wallet> wallets) {
        this.wallets = wallets;
    }
}
