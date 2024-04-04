package com.joel.spring.accounttoken.adapter.output.persistence;

import com.joel.spring.user.util.AccountTokenType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountTokenEntity {
    @Id
    @UuidGenerator
    private String id;

    private String token;

    @Enumerated(EnumType.STRING)
    private AccountTokenType accountTokenType;

    private boolean valid;
    private LocalDate expires;
}
