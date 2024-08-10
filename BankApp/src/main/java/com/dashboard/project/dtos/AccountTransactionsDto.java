package com.dashboard.project.dtos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountTransactionsDto {
    private UUID id;
    private String transactionType;
    private Double amount;
    private String transactionDate;
    private String description;
//    @JsonIgnore
    private UUID accountId;
}
