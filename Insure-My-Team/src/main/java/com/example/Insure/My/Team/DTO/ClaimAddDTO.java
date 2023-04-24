package com.example.Insure.My.Team.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class ClaimAddDTO {

    private int claimNo;
    private String claimDate;
    private String claimStatus;
    private int insurance_id;
    private String description;
}
