package com.example.Insure.My.Team.Repository;

import com.example.Insure.My.Team.Models.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy,Integer> {

    InsurancePolicy findById(int id);
}
