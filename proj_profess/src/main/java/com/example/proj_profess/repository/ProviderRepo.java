package com.example.proj_profess.repository;

import com.example.proj_profess.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProviderRepo extends JpaRepository<Provider, Long> {

    List<Provider> findBySpecialityIdSpeciality(Long idSpeciality );
    List<Provider> findByCityIdCity(Long idCity);
    List<Provider> findBySpecialityIdSpecialityAndCityIdCity(Long idSpeciality,Long idCity );
}
