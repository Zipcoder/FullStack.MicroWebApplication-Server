package com.beansbeans.moneyapp.Services;

import com.beansbeans.moneyapp.Model.Transaction;
import com.beansbeans.moneyapp.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction newTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction showTransaction(Long transactionId) {
        return transactionRepository.findById(transactionId).get();
    }

//    public Transaction update(Long transactionId, Transaction newTransaction){
//        Transaction originalTransaction = transactionRepository.findById(transactionId).get();
//        originalTransaction.setAmount(newTransaction.getAmount());
//        originalTransaction.s
//    }
}
