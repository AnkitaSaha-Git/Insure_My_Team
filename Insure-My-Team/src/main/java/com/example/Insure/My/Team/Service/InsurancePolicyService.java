package com.example.Insure.My.Team.Service;


import com.example.Insure.My.Team.DTO.InsurancePolicyDTO;
import com.example.Insure.My.Team.Models.Client;
import com.example.Insure.My.Team.Models.InsurancePolicy;
import com.example.Insure.My.Team.Repository.ClientRepository;
import com.example.Insure.My.Team.Repository.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsurancePolicyService {

    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;

    @Autowired
    private ClientRepository clientRepository;

    public String addPolicy(InsurancePolicyDTO insurancePolicyDTO, int id){
        Client client=clientRepository.findById(id);
        InsurancePolicy insurancePolicy= new InsurancePolicy();
        insurancePolicy.setEndDate(insurancePolicyDTO.getEndDate());
        insurancePolicy.setStartDate(insurancePolicyDTO.getStartDate());
        insurancePolicy.setCoverageAmount(insurancePolicyDTO.getCoverageAmount());
        insurancePolicyDTO.setPolicy(insurancePolicyDTO.getPolicy());
        insurancePolicyRepository.save(insurancePolicy);
        clientRepository.save(client);
        return "Details added successfully";
    }
}
