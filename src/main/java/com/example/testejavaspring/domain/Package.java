package com.example.testejavaspring.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;
    private String barcode;
    private String description;
    private String type;
    private String deliveryAddress;
    private Date lastUpdate;
    private Date postDate;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Status> history;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Package other = (Package) o;

        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
