package com.example.proj_profess.controller;

import com.example.proj_profess.entity.Contract;
import com.example.proj_profess.service.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/contract")
public class ContractController {
    private ContractService contractService;

    @PostMapping("/add")
    public Contract contractSignup (@RequestBody Contract contract){
        return contractService.addContract(contract);
    }

    @GetMapping("/getContract/{idContract}")
    public Contract getContractById(@PathVariable Long idContract){
        return contractService.getContractById(idContract);
    }

    @GetMapping("/provider/{idProvider}/getAllContract")
    public List<Contract> getAllContractProvider(@PathVariable Long idProvider){
        return contractService.getAllContractProvider(idProvider);
    }

    @GetMapping("/client/{idClient}/getAllContract")
    public List<Contract> getAllContractClient(@PathVariable Long idClient){
        return contractService.getAllContractClient(idClient);
    }

    @PutMapping("/accept/{idContract}")
    public Contract acceptContract(@PathVariable Long idContract){
        return contractService.acceptContract(idContract);
    }
    @PutMapping("/reject/{idContract}")
    public Contract rejectContract(@PathVariable Long idContract){
        return contractService.rejectContract(idContract);
    }

    @DeleteMapping("deleteContract/{idContract}")
    public ResponseEntity<?> deleteContract (@PathVariable Long idContract){
        return contractService.deleteContract(idContract);
    }
D
}
