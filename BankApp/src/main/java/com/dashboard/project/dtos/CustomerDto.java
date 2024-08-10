package com.dashboard.project.dtos;

import com.dashboard.project.entities.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {
    private UUID id;
    private String name;
    private String lastName;
    private AccountDto account;
}
