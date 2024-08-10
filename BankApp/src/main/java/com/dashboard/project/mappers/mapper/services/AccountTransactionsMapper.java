package com.dashboard.project.mappers.mapper.services;

import com.dashboard.project.dtos.AccountTransactionsDto;
import com.dashboard.project.entities.AccountTransactions;
import com.dashboard.project.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AccountTransactionsMapper implements Mapper<AccountTransactions, AccountTransactionsDto> {
    private ModelMapper modelMapper;

    public AccountTransactionsMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public AccountTransactionsDto mapTo(AccountTransactions accountTransactions) {
        return this.modelMapper.map(accountTransactions, AccountTransactionsDto.class);
    }

    @Override
    public AccountTransactions mapFrom(AccountTransactionsDto accountTransactionsDto) {
        return this.modelMapper.map(accountTransactionsDto, AccountTransactions.class);
    }
}
