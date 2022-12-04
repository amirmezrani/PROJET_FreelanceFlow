package com.example.proj_profess.controller;

import com.example.proj_profess.entity.Client;
import com.example.proj_profess.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/signup")
    public Client clientSignup (@RequestBody Client client){
        return clientService.addClient(client);
    }

    @GetMapping("/getClient/{idClient}")
    public Client getClientById(@PathVariable Long idClient){
        return clientService.getClientById(idClient);
    }

    @GetMapping("/getAllClient")
    public List<Client> getAllClients(){
        return clientService.getAllClient();
    }

    @PutMapping("/editClient/{idClient}")
    public Client editClient (@PathVariable Long idClient, @RequestBody Client client ){
        return clientService.editClient(idClient,client);

    }
    @DeleteMapping("deleteClient/{idClient}")
    public ResponseEntity<?> deleteClient (@PathVariable Long idClient){
        return clientService.deleteClient(idClient);
    }
}
