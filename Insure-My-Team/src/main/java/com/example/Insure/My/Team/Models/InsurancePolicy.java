package com.example.Insure.My.Team.Models;

import com.example.Insure.My.Team.Enums.Policy;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="insurance_policy")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InsurancePolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int policyNo;
    private String coverageAmount;
    private String startDate;
    private String endDate;

    @Enumerated(value = EnumType.STRING)
    private Policy policy;

    @ManyToOne
    @JoinColumn
    private Client client;

    @OneToOne(mappedBy = "insurancePolicy",cascade = CascadeType.ALL)
    private Claim claim;

}
