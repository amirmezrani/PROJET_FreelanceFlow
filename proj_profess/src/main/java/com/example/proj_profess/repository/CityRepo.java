package com.example.proj_profess.repository;

import com.example.proj_profess.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City, Long> {
}
