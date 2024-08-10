package com.dashboard.project.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "transactions")
public class AccountTransactions {
    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
     private UUID id;
     private String transactionType;
     private Double amount;
     private String transactionDate;
     private String description;

     @ManyToOne()
     @JoinColumn(name = "account_id")
     private Account account;

}
