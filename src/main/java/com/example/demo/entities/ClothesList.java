package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clothes_list", schema = "public", catalog = "clothes_shop_db")
public class ClothesList {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "amount", nullable = false)
    private int amount;

    @ManyToOne
    @JoinColumn(name = "receipt_id", nullable = false)
    private Receipt receiptId;

    @ManyToOne
    @JoinColumn(name = "size_of_product_id", nullable = false)
    private SizeOfProduct sizeOfProductId;
}
