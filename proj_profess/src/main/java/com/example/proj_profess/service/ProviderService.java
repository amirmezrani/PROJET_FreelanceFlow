package com.example.proj_profess.service;

import com.example.proj_profess.dto.PasswordInfo;
import com.example.proj_profess.entity.City;
import com.example.proj_profess.entity.Provider;
import com.example.proj_profess.entity.Speciality;
import com.example.proj_profess.repository.ProviderRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
@AllArgsConstructor

public class ProviderService {

    private ProviderRepo providerRepo;
    private CityService cityService;
    private SpecialityService specialityService;

    public Provider getProviderById (Long idProvider){
        return  providerRepo.findById(idProvider).orElseThrow(()-> new IllegalArgumentException("Provider ID not Found"));
    }

    public List<Provider> getProviderBySpecialityId (Long idSpeciality){
        return  providerRepo.findBySpecialityIdSpeciality(idSpeciality);
    }

    public List<Provider> getProviderByCityId (Long idCity){
        return  providerRepo.findByCityIdCity(idCity);
    }

    public List<Provider> getProviderBySpecialityIdAndCityId (Long idSpeciality,Long idCity){
        return  providerRepo.findBySpecialityIdSpecialityAndCityIdCity(idSpeciality,idCity);
    }

    public List<Provider> getAllProvider(){
        return providerRepo.findAll();
    }

    public Provider addProvider(Provider provider){
        City city=cityService.getCityById(provider.getCity().getIdCity());
        provider.setCity(city);
        Speciality speciality=specialityService.getSpecialityById(provider.getSpeciality().getIdSpeciality());
        provider.setSpeciality(speciality);
        return providerRepo.save(provider);
    }

    public Provider editProvider(Long idProvider , Provider provider){
        Provider provider1 = getProviderById(idProvider);
        provider1.setFirstName(provider.getFirstName());
        provider1.setLastName(provider.getLastName());
        provider1.setEmail(provider.getEmail());
        provider1.setPhone(provider.getPhone());
        provider1.setBirthday(provider.getBirthday());
        provider1.setCity(provider.getCity());
        provider1.setStreet(provider.getStreet());
        provider1.setPassword(provider.getPassword());
        return providerRepo.save(provider1);

    }

    public Provider editPasswordProvider(Long idProvider, PasswordInfo passwordInfo){
        Provider provider=getProviderById(idProvider);
        if (provider.getPassword().equals(passwordInfo.getPassword())){
            provider.setPassword(passwordInfo.getNewPassword());
            return providerRepo.save(provider);
        }
        else {
            throw new RuntimeException("password not valid");
        }
    }

    public ResponseEntity<?> deleteProvider (Long idProvider){
        providerRepo.deleteById(idProvider);
        return ResponseEntity.ok().build();
    }
}
