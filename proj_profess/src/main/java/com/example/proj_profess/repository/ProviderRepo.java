package com.example.proj_profess.repository;

import com.example.proj_profess.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProviderRepo extends JpaRepository<Provider, Long> {

   /* default List<Provider> findBySpecialityId() {
        return findBySpecialityId();
    }*/

   // List<Provider> findBySpecialityId(Long idSpeciality );
   // List<Provider> findByCityId(Long idCity);
    //List<Provider> findBySpecialityIdAndCityId(Long idSpeciality,Long idCity );
}
