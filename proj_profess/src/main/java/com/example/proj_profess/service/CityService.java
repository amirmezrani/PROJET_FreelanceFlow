package com.example.proj_profess.service;

import com.example.proj_profess.entity.City;
import com.example.proj_profess.repository.CityRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService {

    private CityRepo cityRepo;

    public City getCityById (Long idCity){
        return  cityRepo.findById(idCity).orElseThrow(()-> new IllegalArgumentException("City ID not Found"));
    }

    public List<City> getAllCity(){
        return cityRepo.findAll();
    }

    public City addCity(City city){
        return cityRepo.save(city);
    }

    public City editCity(Long idCity ,City city){
        City city1 = getCityById(idCity);
        city1.setLabel(city.getLabel());

        return cityRepo.save(city1);

    }

    public ResponseEntity<?> deleteCity (Long idCity){
        cityRepo.deleteById(idCity);
        return ResponseEntity.ok().build();
    }
}
