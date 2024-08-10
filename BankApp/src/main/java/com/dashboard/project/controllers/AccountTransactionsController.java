package com.dashboard.project.controllers;

import com.dashboard.project.dtos.AccountTransactionsDto;
import com.dashboard.project.entities.AccountTransactions;
import com.dashboard.project.mappers.Mapper;
import com.dashboard.project.services.AccountTransactionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class AccountTransactionsController {

    private Mapper<AccountTransactions,AccountTransactionsDto> transactionsMapper;
    private AccountTransactionsService accountTransactionsService;

    public AccountTransactionsController(Mapper<AccountTransactions, AccountTransactionsDto> transactionsMapper,
                                         AccountTransactionsService accountTransactionsService
    ) {
        this.transactionsMapper = transactionsMapper;
        this.accountTransactionsService = accountTransactionsService;
    }

//    @PostMapping()
//    public ResponseEntity<AccountTransactionsDto> createTransaction(){
//        return this.accountTransactionsService.createTransaction();
//    }
}
