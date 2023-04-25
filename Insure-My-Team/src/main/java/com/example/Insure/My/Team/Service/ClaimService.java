package com.example.Insure.My.Team.Service;

import com.example.Insure.My.Team.DTO.ClaimAddDTO;
import com.example.Insure.My.Team.Models.Claim;
import com.example.Insure.My.Team.Models.InsurancePolicy;
import com.example.Insure.My.Team.Repository.ClaimRepository;
import com.example.Insure.My.Team.Repository.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClaimService {

    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;

    @Autowired
    private ClaimRepository claimRepository;
    public String addClaim(ClaimAddDTO claimAddDTO){
        int insurance_id=claimAddDTO.getInsurance_id();
        InsurancePolicy insurancePolicy= insurancePolicyRepository.findById(insurance_id);
        Claim claim= new Claim();
        claim.setClaimNo(claimAddDTO.getClaimNo());
        claim.setDescription(claimAddDTO.getDescription());
        claim.setClaimDate(claimAddDTO.getClaimDate());
        claim.setClaimStatus(claimAddDTO.getClaimStatus());

        claim.setInsurancePolicy(insurancePolicy);
        insurancePolicyRepository.save(insurancePolicy);
//        claimRepository.save(claim);
        return "Claim details successfully";
    }

    public List<Claim> getAllClaims(){
//        List<Claim> claim= new ArrayList<>();
        List<Claim> claimPolicies = claimRepository.findAll();
        return claimPolicies;
    }

    public Claim getClaimById(int id){
        Claim claim=claimRepository.findById(id);
        return  claim;
    }

    public String updateClaimStatus(int id, String claimStaus){
        Claim claim= claimRepository.findById(id);
        claim.setClaimStatus(claimStaus);
        claimRepository.save(claim);
        return "Claim status updated successfully";
    }

//    public String deleteClaimById(int id){
//        Claim claim=claimRepository.findById(id);
//        claimRepository.delete(claim);
//        return "Claim by Id deleted successfully";
//    }
}
