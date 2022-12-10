package com.example.proj_profess.repository;

import com.example.proj_profess.entity.Client;
import com.example.proj_profess.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepo extends JpaRepository<Client, Long> {

    Optional<Client> findByEmail(String email);
}
