package com.example.proj_profess.controller;

import com.example.proj_profess.entity.Contract;
import com.example.proj_profess.service.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    //*******
    @GetMapping("/client/{idClient}/getContract/accept")
    public List<Contract> getAllContractAccept(@PathVariable Long idClient){
        return contractService.getAllContractAcceptClient(idClient);
    }

    @GetMapping("/client/{idClient}/getContract/reject")
    public List<Contract> getAllContractReject(@PathVariable Long idClient){
        return contractService.getAllContractRejectClient(idClient);
    }


    @GetMapping("/client/{idClient}/getContract/pending")
    public List<Contract> getAllContractPending(  @PathVariable Long idClient){
        return contractService.getAllContractPendingClient(idClient);
    }

    //*******

    @GetMapping("/provider/{idProvider}/getContract/accept")
    public List<Contract> getAllContractAcceptC(@PathVariable Long idProvider){
        return contractService.getAllContractAcceptProvider(idProvider);
    }

    @GetMapping("/provider/{idProvider}/getContract/reject")
    public List<Contract> getAllContractRejectC(@PathVariable Long idProvider){
        return contractService.getAllContractRejectProvider(idProvider);
    }


    @GetMapping("/provider/{idProvider}/getContract/pending")
    public List<Contract> getAllContractPendingC(  @PathVariable Long idProvider){
        return contractService.getAllContractPendingProvider(idProvider);
    }

    //*******


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

}
