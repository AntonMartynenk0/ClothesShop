package com.example.demo.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Size {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;

    @OneToMany(mappedBy = "sizeId")
    private Collection<SizeOfProduct> sizeOfProductsId;
}
