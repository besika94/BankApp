package com.dashboard.project.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "accounts")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Account {
    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private UUID id;
    private String accountNumber;
    private Double balance;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AccountTransactions> transactions;

    @JsonIgnore
    @OneToOne(mappedBy = "account")
    private Customer customer;
}
