package com.example.Insure.My.Team.Service;


import com.example.Insure.My.Team.DTO.InsurancePolicyDTO;
import com.example.Insure.My.Team.Models.Client;
import com.example.Insure.My.Team.Models.InsurancePolicy;
import com.example.Insure.My.Team.Repository.ClientRepository;
import com.example.Insure.My.Team.Repository.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InsurancePolicyService {

    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;

    @Autowired
    private ClientRepository clientRepository;

    public String addPolicy(InsurancePolicyDTO insurancePolicyDTO){
        int clientId=insurancePolicyDTO.getClient_id();
       Client  client=clientRepository.findById(clientId);

        InsurancePolicy insurancePolicy= new InsurancePolicy();
        insurancePolicy.setPolicyNo(insurancePolicyDTO.getPolicyNo());
        insurancePolicy.setEndDate(insurancePolicyDTO.getEndDate());
        insurancePolicy.setStartDate(insurancePolicyDTO.getStartDate());
        insurancePolicy.setCoverageAmount(insurancePolicyDTO.getCoverageAmount());
        insurancePolicy.setPolicy(insurancePolicyDTO.getPolicy());

        //Setting the foreign key attribute in child class
        insurancePolicy.setClient(client);

        List<InsurancePolicy> insurancePolicyList=client.getInsurancePolicies();
        insurancePolicyList.add(insurancePolicy);
        clientRepository.save(client);

        return "Details added successfully";
    }



    public List<InsurancePolicy> getAllInsurancePolicies(){
//        List<InsurancePolicy> insurancePolicyList=new ArrayList<>();
//        for(InsurancePolicy insurancePolicy:insurancePolicyRepository.findAll()){
//            insurancePolicyList.add(insurancePolicy);
//        }
        List<InsurancePolicy> insurancePolicies = insurancePolicyRepository.findAll();
        return insurancePolicies;
        //return insurancePolicyRepository.findAll();
    }

    public InsurancePolicy getInsurancePolicyById(int insurance_id){
        InsurancePolicy insurancePolicy=insurancePolicyRepository.findById(insurance_id);
            return insurancePolicy;
    }

    public String deleteInsurancePolicy(int id){
        insurancePolicyRepository.deleteById(id);
        return "Deleted successfully";
    }

    public String updateInsurancePolicy(int id, InsurancePolicyDTO updatedInsurancePolicyDTO){

        return "Updated successfully";
    }
}
