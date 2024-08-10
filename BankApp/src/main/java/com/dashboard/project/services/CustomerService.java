package com.dashboard.project.services;

import com.dashboard.project.entities.Account;
import com.dashboard.project.entities.Customer;
import com.dashboard.project.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    private AccountService accountService;

    public CustomerService(CustomerRepository customerRepository, AccountService accountService) {
        this.customerRepository = customerRepository;
        this.accountService = accountService;
    }

    public Customer save(Customer customer) {
        // check if account exists in the customer object
        if(customer.getAccount() != null){
            //check if account needs to be created
            if(customer.getAccount().getId() == null){
                Account newAccount = this.accountService.save(customer.getAccount());
                customer.setAccount(newAccount);
                // check if associated account exists
            }else if(!this.accountService.isPresent(customer.getAccount().getId().toString())){
                customer.setAccount(null);
            }else {
                // get the account from the database
                Account account = this.accountService.getAccount(customer.getAccount().getId());
                customer.setAccount(account);
            }
        }
        return this.customerRepository.save(customer);
    }

    public Customer getCustomer(String id) {
        return this.customerRepository.findById(UUID.fromString(id)).orElse(null);
    }

    public boolean isPresent(String id) {
        return this.customerRepository.existsById(UUID.fromString(id));
    }

    public List<Customer> getCustomers() {
        return StreamSupport.stream(this.customerRepository
                .findAll()
                .spliterator(),
                false)
                .collect(Collectors.toList());
    }
}
