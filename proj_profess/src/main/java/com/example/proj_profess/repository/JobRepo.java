package com.example.proj_profess.repository;

import com.example.proj_profess.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepo extends JpaRepository<Job, Long> {

    List<Job> findByProviderId(Long idProvider );
}
