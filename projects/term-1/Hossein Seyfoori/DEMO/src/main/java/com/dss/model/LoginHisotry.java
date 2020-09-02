package com.dss.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class LoginHisotry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date login_time;
    private Date logout_time;
    private String ip;
    private String browser;


}
