package com.dashboard.project.controllers;

import com.dashboard.project.dtos.AccountDto;
import com.dashboard.project.entities.Account;
import com.dashboard.project.mappers.Mapper;
import com.dashboard.project.services.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;
    private Mapper<Account, AccountDto> accountMapper;

    public AccountController(AccountService accountService, Mapper<Account, AccountDto> accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @PostMapping()
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        if(accountDto.getBalance() != null && accountDto.getBalance() < 0){
            return ResponseEntity.badRequest().build();
        }
        Account account = this.accountMapper.mapFrom(accountDto);
        Account savedAccount = this.accountService.save(account);
        return ResponseEntity.ok(this.accountMapper.mapTo(savedAccount));

    }

    @GetMapping()
    public ResponseEntity<List<AccountDto>> getAccounts(){
        List<Account> accounts = this.accountService.getAccounts();
        return ResponseEntity.ok(accounts.stream()
                .map(this.accountMapper::mapTo)
                .collect(Collectors.toList()));
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> makeDeposit(
            @PathVariable("id") String id,
            @RequestBody Map<String, Double> request
    ) {
        Double amount = request.get("amount");
        Optional<Account> account = this.accountService.deposit(id, amount);
        return account.map(value -> ResponseEntity.ok(this.accountMapper.mapTo(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> makeWithdraw(
            @PathVariable("id") String id,
            @RequestBody Map<String, Double> request
    ) {
        Double amount = request.get("amount");
        Optional<Account> account = this.accountService.withdraw(id, amount);
        return account.map(value -> ResponseEntity.ok(this.accountMapper.mapTo(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
