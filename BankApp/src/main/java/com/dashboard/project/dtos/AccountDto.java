package com.dashboard.project.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {
    private UUID id;
    private String accountNumber;
    private Double balance;
    private List<AccountTransactionsDto> transactions;
    private UUID customerId;
}
