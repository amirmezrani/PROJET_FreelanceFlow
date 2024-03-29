package com.example.proj_profess.service;

import com.example.proj_profess.entity.Contract;
import com.example.proj_profess.repository.ContractRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ContractService {
    private ContractRepo contractRepo;
    private ProviderService providerService;
    private ClientService clientService;
    private JobService jobService;
    private MailSenderService mailSenderService;

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

    // ***************
    public List<Contract> getAllContractAcceptClient(Long idClient){
        List<Contract> contracts= getAllContractClient(idClient);
        List<Contract> contracts1= new ArrayList<>();
        for (Contract contract:contracts){
            if (contract.getResponse().equals("true")){
                contracts1.add(contract);
            }
        }
        return contracts1;
    }

    public List<Contract> getAllContractRejectClient(Long idClient){
        List<Contract> contracts= getAllContractClient(idClient);
        List<Contract> contracts1= new ArrayList<>();
        for (Contract contract:contracts){
            if (contract.getResponse().equals("false")){
                contracts1.add(contract);
            }
        }
        return contracts1;
    }


    public List<Contract> getAllContractPendingClient(Long idClient){
        List<Contract> contracts= getAllContractClient(idClient);
        List<Contract> contracts1= new ArrayList<>();
        for (Contract contract:contracts){
            if (contract.getResponse()==""){
                contracts1.add(contract);
            }
        }
        return contracts1;
    }

    // ***************

    public List<Contract> getAllContractAcceptProvider(Long idProvider){
        List<Contract> contracts= getAllContractProvider(idProvider);
        List<Contract> contracts1= new ArrayList<>();
        for (Contract contract:contracts){
            if (contract.getResponse().equals("true")){
                contracts1.add(contract);
            }
        }
        return contracts1;
    }

    public List<Contract> getAllContractRejectProvider(Long idProvider){
        List<Contract> contracts= getAllContractProvider(idProvider);
        List<Contract> contracts1= new ArrayList<>();
        for (Contract contract:contracts){
            if (contract.getResponse().equals("false")){
                contracts1.add(contract);
            }
        }
        return contracts1;
    }


    public List<Contract> getAllContractPendingProvider(Long idProvider) {
        List<Contract> contracts = getAllContractProvider(idProvider);
        List<Contract> contracts1= new ArrayList<>();
        for (Contract contract:contracts){
            if (contract.getResponse()==""){
                contracts1.add(contract);
            }
        }
        return contracts1;
    }

        //********

        public Contract addContract(Contract contract){

       /* Provider provider= providerService.getProviderById(contract.getProvider().getId());
        Client client= clientService.getClientById(contract.getClient().getId());
        Job job=jobService.getJobById(contract.getJob().getIdJob());


        contract.setJob(job);
        contract.setClient(client);
        contract.setProvider(provider);*/


        //provider.getContractList().add(contract);
        //client.getContractList().add(contract);
        contract.setLocalDateTime(LocalDateTime.now());
        contract.setResponse("");

        return contractRepo.save(contract);
    }

    public Contract acceptContract(Long idContract){
        Contract contract=getContractById(idContract);
        contract.setResponse("true");
        try {
            this.mailSenderService.send(contract.getClient().getEmail(),
                    "Acceptation de Service  ",
                    "Bonjour,<br>\n " +
                            "Votre demande de service sur notre application a été acceptée.<br>\n " +
                            "Merci pour votre confiance.<br>\n" +
                            " Cordialement");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

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
