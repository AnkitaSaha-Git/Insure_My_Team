package com.example.Insure.My.Team.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="claim")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int claimNo;
    private Date claimDate;
    private String claimStatus;

    @OneToOne
    @JoinColumn
    private InsurancePolicy insurancePolicy;
}
