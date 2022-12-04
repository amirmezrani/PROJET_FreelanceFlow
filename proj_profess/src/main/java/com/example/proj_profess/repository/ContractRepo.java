package com.example.proj_profess.repository;

import com.example.proj_profess.entity.Contract;
import com.example.proj_profess.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractRepo extends JpaRepository<Contract,Long> {

    List<Contract> findByProviderId(Long idProvider );
    List<Contract> findByClientId(Long idClient );
}
