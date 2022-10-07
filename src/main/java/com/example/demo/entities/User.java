package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "user_details"
)
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;
    @Basic
    @Column(name = "surname", nullable = false, length = -1)
    private String surname;
    @Basic
    @Column(name = "email", nullable = true, length = -1)
    private String email;
    @Basic
    @Column(name = "phone", nullable = true, length = -1)
    private String phone;
    @Basic
    @Column(name = "password", nullable = false, length = -1)
    private String password;
    @Basic
    @Column(name = "date_of_reg", nullable = false)
    private Date dateOfReg;

    @OneToMany(mappedBy = "userId")
    private Collection<Receipt> receiptsId;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role roleId;

    public User(String name, String surname, String email, String phone, String password, Date dateOfReg, Role roleId) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.dateOfReg = dateOfReg;
        this.roleId = roleId;
        this.receiptsId = null;
    }
}
