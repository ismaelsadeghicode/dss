package com.dss.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Bank {

    @Id
    private int id;
    private String cardNo;
    private String accountNo;
    private String name;
    private boolean isActive;




}
