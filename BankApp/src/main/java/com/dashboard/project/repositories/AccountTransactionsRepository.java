package com.dashboard.project.repositories;

import com.dashboard.project.entities.AccountTransactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountTransactionsRepository extends CrudRepository<AccountTransactions, UUID> {
}
