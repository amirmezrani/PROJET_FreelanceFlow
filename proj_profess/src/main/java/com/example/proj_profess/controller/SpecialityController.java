package com.example.proj_profess.controller;

import com.example.proj_profess.entity.Speciality;
import com.example.proj_profess.service.SpecialityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/speciality")
@AllArgsConstructor
public class SpecialityController {


    private SpecialityService specialityService;

    @PostMapping("/add")
    public Speciality specialitySignup (@RequestBody Speciality speciality){
        return specialityService.addSpeciality(speciality);
    }

    @GetMapping("/getSpeciality/{idSpeciality}")
    public Speciality getSpecialityById(@PathVariable Long idSpeciality){
        return specialityService.getSpecialityById(idSpeciality);
    }

    @GetMapping("/getAllSpeciality")
    public List<Speciality> getAllSpeciality(){
        return specialityService.getAllSpeciality();
    }

    @PutMapping("/editSpeciality/{idSpeciality}")
    public Speciality editSpeciality (@PathVariable Long idSpeciality, @RequestBody Speciality speciality ){
        return specialityService.editSpeciality(idSpeciality,speciality);
    }

    @DeleteMapping("deleteSpeciality/{idSpeciality}")
    public ResponseEntity<?> deleteSpeciality (@PathVariable Long idSpeciality){
        return specialityService.deleteSpeciality(idSpeciality);
    }

}
