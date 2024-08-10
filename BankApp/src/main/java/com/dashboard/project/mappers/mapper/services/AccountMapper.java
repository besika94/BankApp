package com.dashboard.project.mappers.mapper.services;

import com.dashboard.project.dtos.AccountDto;
import com.dashboard.project.entities.Account;
import com.dashboard.project.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper implements Mapper<Account, AccountDto> {

    private ModelMapper modelMapper;

    public AccountMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AccountDto mapTo(Account account) {
        return this.modelMapper.map(account, AccountDto.class);
    }

    @Override
    public Account mapFrom(AccountDto accountDto) {
        return this.modelMapper.map(accountDto, Account.class);
    }
}
