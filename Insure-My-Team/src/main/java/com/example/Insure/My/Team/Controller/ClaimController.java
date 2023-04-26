package com.example.Insure.My.Team.Controller;

import com.example.Insure.My.Team.DTO.ClaimAddDTO;
import com.example.Insure.My.Team.Models.Claim;
import com.example.Insure.My.Team.Service.ClaimService;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;
    @PostMapping
    public String addClaim(@RequestBody ClaimAddDTO claimAddDTO){

        return claimService.addClaim(claimAddDTO);
    }

    @GetMapping
    public List<Claim> getAllClaims(){
        return claimService.getAllClaims();
    }

    @GetMapping("/{id}")
    public Claim getClaimById(@PathVariable int id){
        return claimService.getClaimById(id);
    }

    @PutMapping("/{id}")
    public String updateClaimStatus(@PathVariable int id, @RequestParam("status") String claimStatus){
        return claimService.updateClaimStatus(id, claimStatus);
    }


    //Used exception handling in case of incorrect id
    @DeleteMapping("/{id}")
    public String deleteClaimByID(@PathVariable int id){
       try{
           return claimService.deleteClaimById(id);
          }
       catch(Exception e){
           return e.getMessage();
       }
    }
}
