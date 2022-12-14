package com.example.proj_profess.service;

import com.example.proj_profess.dto.Auth;
import com.example.proj_profess.dto.PasswordInfo;
import com.example.proj_profess.entity.City;
import com.example.proj_profess.entity.Provider;
import com.example.proj_profess.entity.Speciality;
import com.example.proj_profess.repository.ProviderRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
@AllArgsConstructor

public class ProviderService {

    private ProviderRepo providerRepo;
    private CityService cityService;
    private SpecialityService specialityService;
    MailSenderService mailSenderService;

    public Provider getProviderById (Long idProvider){
        return  providerRepo.findById(idProvider).orElseThrow(()-> new IllegalArgumentException("Provider ID not Found"));
    }

    public Provider getProviderByEmail (String email){
        Provider provider=  providerRepo.findByEmail(email).
                orElseThrow(()-> new IllegalArgumentException("Provider email not Found"));
        return provider;
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
        provider1.setDescription(provider.getDescription());
        provider1.setLatitude(provider.getLatitude());
        provider1.setLongitude(provider.getLongitude());
        return providerRepo.save(provider1);

    }

    public Provider editPasswordProvider(Long idProvider, PasswordInfo passwordInfo){
        Provider provider=getProviderById(idProvider);
        if (provider.getPassword().equals(passwordInfo.getPassword())){
            provider.setPassword(passwordInfo.getNewPassword());
            try {
                this.mailSenderService.send(provider.getEmail(),
                        "Modfication de mot de passe  ",
                        "Bonjour,<br>\n " +
                                "Votre mot de passe a été changé.<br>\n " +
                                "Merci pour votre confiance.<br>\n" +
                                " Cordialement");

            } catch (MessagingException e) {
                e.printStackTrace();
            }
            return providerRepo.save(provider);
        }
        else {
            throw new RuntimeException("password not valid");
        }
    }

    public Provider authenticateProvider(Auth auth)
    {
        Provider provider  = getProviderByEmail(auth.getEmail());
        boolean isAuthenticated = false;
        if(provider!=null)
        {
            if(provider.getPassword().equals(auth.getPassword()))
            {
                isAuthenticated = true;
            }

        }
        if(isAuthenticated)
            return provider;
        else
            throw new IllegalArgumentException("password not valid");

    }

    public Provider feedBack(Long idProvider, int feed ){
        Provider provider=getProviderById(idProvider);
        int numb= provider.getNumbFeed();
        double f=(provider.getFeed()*numb)+feed;
        numb++;
        f=f/numb;
        provider.setFeed(f);
        provider.setNumbFeed(provider.getNumbFeed()+1);

        return providerRepo.save(provider);
    }

    public ResponseEntity<?> deleteProvider (Long idProvider){
        providerRepo.deleteById(idProvider);
        return ResponseEntity.ok().build();
    }
}
