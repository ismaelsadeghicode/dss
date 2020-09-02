package com.dss.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class SmsVerification {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;
    private String code;
    private Date start_time;
    private Date end_time;
}
