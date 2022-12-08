package com.example.proj_profess.controller;

import com.example.proj_profess.dto.PasswordInfo;
import com.example.proj_profess.entity.Provider;
import com.example.proj_profess.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @PostMapping("/signup")
    public Provider providerSignup (@RequestBody Provider provider){
        return providerService.addProvider(provider);
    }

    @GetMapping("/getProvider/{idProvider}")
    public Provider getProviderById(@PathVariable Long idProvider){
        return providerService.getProviderById(idProvider);
    }

    @GetMapping("/getAllProvider")
    public List<Provider> getAllProviders(){
        return providerService.getAllProvider();
    }

    @GetMapping("/speciality/{idSpeciality}/getProvider")
    public List<Provider> getProviderBySpecialityId (@PathVariable Long idSpeciality){
        return  providerService.getProviderBySpecialityId(idSpeciality);
    }

    @GetMapping("/city/{idCity}/getProvider")
    public List<Provider> getProviderByCityId (@PathVariable Long idCity){
        return  providerService.getProviderByCityId(idCity);
    }

    @GetMapping("/speciality/{idSpeciality}/city/{idCity}/getProvider")
    public List<Provider> getProviderBySpecialityIdAndCityId (@PathVariable Long idSpeciality,
                                                              @PathVariable Long idCity){
        return  providerService.getProviderBySpecialityIdAndCityId(idSpeciality,idCity);
    }

    @PutMapping("/editProvider/{idProvider}")
    public Provider editProvider (@PathVariable Long idProvider, @RequestBody Provider provider ){
        return providerService.editProvider(idProvider,provider);
    }

    @PutMapping("/editPassword/{idProvider}")
    public Provider editPasswordProvider(@PathVariable Long idProvider, @RequestBody PasswordInfo passwordInfo){
        return providerService.editPasswordProvider(idProvider,passwordInfo);

    }

    @DeleteMapping("deleteProvider/{idProvider}")
    public ResponseEntity<?> deleteProvider (@PathVariable Long idProvider){
        return providerService.deleteProvider(idProvider);
    }


}

