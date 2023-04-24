package com.example.Insure.My.Team.Controller;


import com.example.Insure.My.Team.DTO.InsurancePolicyDTO;
import com.example.Insure.My.Team.Models.InsurancePolicy;
import com.example.Insure.My.Team.Service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class InsurancePolicyController {

    @Autowired
    InsurancePolicyService insurancePolicyService;

    @PostMapping("/addPolicy")
    public String addPolicy(@RequestBody InsurancePolicyDTO insurancePolicyDTO){

        return insurancePolicyService.addPolicy(insurancePolicyDTO);
    }

    @GetMapping("/getAll")
    public List<InsurancePolicy> getAllInsurancePolicies(){
        return insurancePolicyService.getAllInsurancePolicies();
    }

    @GetMapping("/{insurance_id}")
    public InsurancePolicy getInsurancePolicyById(@PathVariable int insurance_id){
        return insurancePolicyService.getInsurancePolicyById(insurance_id);
    }

    @DeleteMapping("/{id}")
    public String deleteInsurancePolicy(@PathVariable int id){
        return insurancePolicyService.deleteInsurancePolicy(id);
    }

//    @PutMapping("/{id}")
//    public String updateInsurancePolicy(@PathVariable int id, @RequestBody InsurancePolicy updatedInsurancePolicy){
//
//        return insurancePolicyService.updateInsurancePolicy(id,updatedInsurancePolicy);
//    }

}
