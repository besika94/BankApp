package com.dashboard.project.controllers;

import com.dashboard.project.dtos.CustomerDto;
import com.dashboard.project.entities.Account;
import com.dashboard.project.entities.Customer;
import com.dashboard.project.mappers.Mapper;
import com.dashboard.project.services.AccountService;
import com.dashboard.project.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private CustomerService customerService;
    private Mapper<Customer, CustomerDto> customerMapper;

    public CustomerController(CustomerService customerService, Mapper<Customer, CustomerDto> customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }


    @PostMapping()
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = this.customerMapper.mapFrom(customerDto);
        Customer savedCustomer = this.customerService.save(customer);
        return ResponseEntity.ok(this.customerMapper.mapTo(savedCustomer));

    }


    @GetMapping()
    public ResponseEntity<List<CustomerDto>> getCustomers(){
        List<Customer> customers = this.customerService.getCustomers();

        return ResponseEntity.ok(customers.stream()
                .map(this.customerMapper::mapTo)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("id") String id) {
        if(!this.customerService.isPresent(id)) {
            return ResponseEntity.notFound().build();
        }
        Customer customer = this.customerService.getCustomer(id);

        return ResponseEntity.ok(this.customerMapper.mapTo(customer));
    }



}
