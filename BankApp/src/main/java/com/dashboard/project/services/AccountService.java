package com.dashboard.project.services;

import com.dashboard.project.dtos.AccountTransactionsDto;
import com.dashboard.project.entities.Account;
import com.dashboard.project.entities.AccountTransactions;
import com.dashboard.project.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AccountService {
    private AccountRepository accountRepository;
    private AccountTransactionsService accountTransactionsService;

    public AccountService(
            AccountRepository accountRepository,
            AccountTransactionsService accountTransactionsService
    ) {
        this.accountRepository = accountRepository;
        this.accountTransactionsService = accountTransactionsService;
    }

    public Account save(Account account) {

        return this.accountRepository.save(account);
    }

    public boolean isPresent(String id) {
        return this.accountRepository.existsById(UUID.fromString(id));
    }

    public List<Account> getAccounts() {
        return StreamSupport.stream(this.accountRepository
                .findAll()
                .spliterator(),
                false)
                .collect(Collectors.toList()
        );
    }

    public Optional<Account> deposit(String id, Double amount) {
        Account account = this.accountRepository.findById(UUID.fromString(id)).orElse(null);
        if(account == null){
            return Optional.empty();
        }
        account.setBalance(account.getBalance() + amount);
        AccountTransactions transactions = AccountTransactions.builder()
                .transactionType("DEPOSIT")
                .amount(amount)
                .transactionDate(LocalDateTime.now().toString())
                .description("Deposit made")
                .account(account)
                .build();
        AccountTransactions transaction = this.accountTransactionsService.createTransaction(transactions);
        if(transaction == null){
            return Optional.empty();
        }

        return Optional.of(this.accountRepository.save(account));
    }

    public Optional<Account> withdraw(String id, Double amount) {
        Account account = this.accountRepository.findById(UUID.fromString(id)).orElse(null);
        if(account == null || account.getBalance() < amount){
            return Optional.empty();
        }

        account.setBalance(account.getBalance() - amount);

        AccountTransactions transactions = AccountTransactions.builder()
                .transactionType("WITHDRAW")
                .amount(amount)
                .transactionDate(LocalDateTime.now().toString())
                .description("Withdraw made")
                .account(account)
                .build();

        AccountTransactions transaction = this.accountTransactionsService.createTransaction(transactions);
        if(transaction == null){
            return Optional.empty();
        }

        return Optional.of(this.accountRepository.save(account));
    }

    public Account getAccount(UUID id) {
        return this.accountRepository.findById(id).orElse(null);
    }
}
