package com.example.testejavaspring.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Package pack;
    private Date date;
    private String city;
    private String state;
    private String comments;
}
