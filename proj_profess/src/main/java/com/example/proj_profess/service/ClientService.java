package com.example.proj_profess.service;

import com.example.proj_profess.entity.City;
import com.example.proj_profess.entity.Client;
import com.example.proj_profess.repository.ClientRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {

    private ClientRepo clientRepo;
    private CityService cityService;

    public Client getClientById (Long idClient){
        return  clientRepo.findById(idClient).orElseThrow(()-> new IllegalArgumentException("Client ID not Found"));
    }

    public List<Client> getAllClient(){
        return clientRepo.findAll();
    }

    public Client addClient(Client client){
        City city=cityService.getCityById(client.getCity().getIdCity());
        client.setCity(city);
        return clientRepo.save(client);
    }

    public Client editClient(Long idClient ,Client client){
        Client client1 = getClientById(idClient);
        client1.setFirstName(client.getFirstName());
        client1.setLastName(client.getLastName());
        client1.setEmail(client.getEmail());
        client1.setPhone(client.getPhone());
        client1.setBirthday(client.getBirthday());
        client1.setCity(client.getCity());
        client1.setStreet(client.getStreet());
        client1.setPassword(client.getPassword());
        return clientRepo.save(client1);

    }

    public ResponseEntity<?> deleteClient (Long idClient){
        clientRepo.deleteById(idClient);
        return ResponseEntity.ok().build();
    }



}
