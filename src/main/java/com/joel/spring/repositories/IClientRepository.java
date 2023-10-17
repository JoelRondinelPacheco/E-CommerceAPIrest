package com.joel.spring.repositories;

import com.joel.spring.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {
}
