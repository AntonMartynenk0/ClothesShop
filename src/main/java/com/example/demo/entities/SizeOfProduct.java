package com.example.demo.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "size_of_product", schema = "public", catalog = "clothes_shop_db")
public class SizeOfProduct {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "quantity", nullable = false)
    private int quantity;

    @OneToMany(mappedBy = "sizeOfProductId")
    private Collection<ClothesList> clothesListsId;
    @ManyToOne
    @JoinColumn(name = "size_id", nullable = false)
    private Size sizeId;
    @ManyToOne
    @JoinColumn(name = "clothes_id", nullable = false)
    private Clothes clothesId;
    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false)
    private Color colorId;
}
