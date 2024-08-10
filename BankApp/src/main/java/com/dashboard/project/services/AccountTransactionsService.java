package com.dashboard.project.services;

import com.dashboard.project.dtos.AccountTransactionsDto;
import com.dashboard.project.entities.AccountTransactions;
import com.dashboard.project.mappers.Mapper;
import com.dashboard.project.repositories.AccountTransactionsRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountTransactionsService {

    private Mapper<AccountTransactions,AccountTransactionsDto> transactionsMapper;
    private AccountTransactionsRepository accountTransactionsRepository;

    public AccountTransactionsService(
            Mapper<AccountTransactions, AccountTransactionsDto> transactionsMapper,
            AccountTransactionsRepository accountTransactionsRepository
    ) {
        this.transactionsMapper = transactionsMapper;
        this.accountTransactionsRepository = accountTransactionsRepository;
    }

    public AccountTransactions createTransaction(AccountTransactions transaction) {
        return this.accountTransactionsRepository.save(transaction);
    }
}
