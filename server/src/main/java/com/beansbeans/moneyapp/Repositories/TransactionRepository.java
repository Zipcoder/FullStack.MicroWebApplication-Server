package com.beansbeans.moneyapp.Repositories;

import com.beansbeans.moneyapp.Model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
