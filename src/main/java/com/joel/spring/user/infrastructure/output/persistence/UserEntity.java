package com.joel.spring.user.infrastructure.output.persistence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.joel.spring.entities.Cart;
import com.joel.spring.sales.adapter.output.persistence.SaleEntity;
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
@JsonIgnoreProperties("saleEntities")
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
    private boolean enabled;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "account_token_id")
    private AccountTokenEntity accountToken;

    @OneToMany(mappedBy = "client")
    private List<SaleEntity> saleEntities;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public UserEntity() {
    }

    public UserEntity(String firstName, String lastName, String email, String password, AccountTokenEntity accountToken) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.accountToken = accountToken;
        this.enabled = false;

    }
}
