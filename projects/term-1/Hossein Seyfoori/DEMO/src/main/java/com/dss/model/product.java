package com.dss.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String CodeHaraji;
    private String description;
    private String price;
    private LocalDateTime startSales;
    @OneToMany
    private List<UserT> sherkatKonandeha;


}
