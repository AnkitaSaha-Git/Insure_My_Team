package com.example.Insure.My.Team.Repository;

import com.example.Insure.My.Team.Models.Claim;
import com.example.Insure.My.Team.Models.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {
    Claim findById(int id);

}
