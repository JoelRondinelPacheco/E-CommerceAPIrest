package com.joel.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@JsonIgnoreProperties("sales")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private LocalDate created;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dni;
    @OneToMany(mappedBy = "client")
    private List<Sale> sales;

    public UserEntity() {
    }

    public UserEntity(String firstName, String lastName, String dni) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
    }
}
