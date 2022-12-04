package com.example.proj_profess.service;

import com.example.proj_profess.entity.Client;
import com.example.proj_profess.entity.Contract;
import com.example.proj_profess.entity.Job;
import com.example.proj_profess.entity.Provider;
import com.example.proj_profess.repository.ContractRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContractService {
    private ContractRepo contractRepo;
    private ProviderService providerService;
    private ClientService clientService;
    private JobService jobService;

    public Contract getContractById (Long idContract){
        return  contractRepo.findById(idContract)
                .orElseThrow(()-> new IllegalArgumentException("Contract ID not Found"));
    }

    public List<Contract> getAllContractProvider(Long idProvider){
        return contractRepo.findByProviderId(idProvider);
    }

    public List<Contract> getAllContractClient(Long idClient){
        return contractRepo.findByClientId(idClient);
    }

    public Contract addContract(Contract contract){

       /* Provider provider= providerService.getProviderById(contract.getProvider().getId());
        Client client= clientService.getClientById(contract.getClient().getId());
        Job job=jobService.getJobById(contract.getJob().getIdJob());


        contract.setJob(job);
        contract.setClient(client);
        contract.setProvider(provider);*/


        //provider.getContractList().add(contract);
        //client.getContractList().add(contract);

        return contractRepo.save(contract);
    }

    public Contract acceptContract(Long idContract){
        Contract contract=getContractById(idContract);
        contract.setResponse("true");

        return contractRepo.save(contract);

    }

    public Contract rejectContract(Long idContract){
        Contract contract=getContractById(idContract);
        contract.setResponse("false");

        return contractRepo.save(contract);

    }



    public ResponseEntity<?> deleteContract (Long idContract){
        contractRepo.deleteById(idContract);
        return ResponseEntity.ok().build();
    }
}
