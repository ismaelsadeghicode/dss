package com.dss.sales.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import javax.persistence.*;
import javax.validation.constraints.Null;

@Entity
@Table(name = "USER_T")
@Data
@NoArgsConstructor
public class Users {

    @Column(name = "USERNAME")
    @Null
    private String username;

    @Column(name = "PASSWORD")
    @NonNull
    private String password;

    @Id
    @Column(name = "ID",unique = true)
    @NonNull
    private int id;

    @Column(name = "PHONE_NUMBER")
    @Null
    private String phoneNumber;

    @Column(name = "MALE",nullable = true)
    @Null
    private boolean isMale;

    @Column(name = "FEMALE", nullable = true)
    @Null
    private boolean isFemale;

    @Column(name="Wallet")
    @Null
    private long wallet;

}
