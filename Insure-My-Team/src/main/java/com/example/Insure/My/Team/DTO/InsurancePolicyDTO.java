package com.example.Insure.My.Team.DTO;

import com.example.Insure.My.Team.Enums.Policy;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class InsurancePolicyDTO {
    private int policyNo;
    private String coverageAmount;
    private String startDate;
    private String endDate;
    private int clientId;

    @Enumerated(value = EnumType.STRING)
    private Policy policy;

}
