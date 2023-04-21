package com.example.Insure.My.Team.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="client")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String dateOfBirth;
    private String address;
    private String contactNo;

    @OneToMany(mappedBy = "client", cascade =CascadeType.ALL )
    private List<InsurancePolicy> insurancePolicies= new ArrayList<>();
}
