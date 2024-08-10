package com.dashboard.project.mappers.mapper.services;

import com.dashboard.project.dtos.CustomerDto;
import com.dashboard.project.entities.Customer;
import com.dashboard.project.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper implements Mapper<Customer, CustomerDto> {

    private ModelMapper modelMapper;

    public CustomerMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerDto mapTo(Customer customer) {
        return this.modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    public Customer mapFrom(CustomerDto customerDto) {
        return this.modelMapper.map(customerDto, Customer.class);
    }
}
