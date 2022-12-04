package com.example.proj_profess.repository;

import com.example.proj_profess.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {
}
