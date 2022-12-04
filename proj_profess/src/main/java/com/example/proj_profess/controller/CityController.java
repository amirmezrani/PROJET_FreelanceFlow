package com.example.proj_profess.controller;

import com.example.proj_profess.entity.City;
import com.example.proj_profess.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/city")
@AllArgsConstructor
public class CityController {

    private CityService cityService;

    @PostMapping("/add")
    public City cityAdd (@RequestBody City city){
        return cityService.addCity(city);
    }

    @GetMapping("/getCity/{idCity}")
    public City getCityById(@PathVariable Long idCity){
        return cityService.getCityById(idCity);
    }

    @GetMapping("/getAllCity")
    public List<City> getAllCity(){
        return cityService.getAllCity();
    }

    @PutMapping("/editCity/{idCity}")
    public City editCity (@PathVariable Long idCity, @RequestBody City city ){
        return cityService.editCity(idCity,city);
    }

    @DeleteMapping("deleteCity/{idCity}")
    public ResponseEntity<?> deleteCity (@PathVariable Long idCity){
        return cityService.deleteCity(idCity);
    }
}
