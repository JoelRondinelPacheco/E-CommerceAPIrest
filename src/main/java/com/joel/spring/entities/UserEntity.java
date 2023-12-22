package com.joel.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@JsonIgnoreProperties("sales")
public class UserEntity {
    @Id
    @UuidGenerator
    private String id;
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private LocalDate created;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @OneToMany(mappedBy = "client")
    private List<Sale> sales;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public UserEntity() {
    }

    public UserEntity(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
