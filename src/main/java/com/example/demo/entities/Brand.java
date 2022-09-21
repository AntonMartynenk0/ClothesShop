package com.example.demo.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Brand {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;
    @OneToMany(mappedBy = "brandId")
    private Collection<Clothes> clothesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brand brand = (Brand) o;

        if (id != brand.id) return false;
        if (name != null ? !name.equals(brand.name) : brand.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<Clothes> getClothesById() {
        return clothesById;
    }

    public void setClothesById(Collection<Clothes> clothesById) {
        this.clothesById = clothesById;
    }
}
