package com.example.Insure.My.Team.Controller;


import com.example.Insure.My.Team.DTO.InsurancePolicyDTO;
import com.example.Insure.My.Team.Models.InsurancePolicy;
import com.example.Insure.My.Team.Service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/policies")
public class InsurancePolicyController {

    @Autowired
    InsurancePolicyService insurancePolicyService;

    @PostMapping("/addPolicy")
    public String addPolicy(@RequestBody InsurancePolicyDTO insurancePolicyDTO, @PathVariable int id){

        return insurancePolicyService.addPolicy(insurancePolicyDTO,id);
    }
}
