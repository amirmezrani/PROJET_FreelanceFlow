package com.example.proj_profess.service;

import com.example.proj_profess.entity.Speciality;
import com.example.proj_profess.repository.SpecialityRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class SpecialityService {

    @Autowired
    private SpecialityRepo specialityRepo;

    public Speciality getSpecialityById (Long idSpeciality){
        return  specialityRepo.findById(idSpeciality).orElseThrow(()-> new IllegalArgumentException("Speciality ID not Found"));
    }

    public List<Speciality> getAllSpeciality(){
        return specialityRepo.findAll();
    }


    public Speciality addSpeciality(Speciality speciality){
        return specialityRepo.save(speciality);
    }

    public Speciality editSpeciality(Long idSpeciality ,Speciality speciality){
        Speciality speciality1 = getSpecialityById(idSpeciality);
        speciality1.setLabel(speciality.getLabel());
        return specialityRepo.save(speciality1);

    }

    public ResponseEntity<?> deleteSpeciality (Long idSpeciality){
        specialityRepo.deleteById(idSpeciality);
        return ResponseEntity.ok().build();
    }
}
