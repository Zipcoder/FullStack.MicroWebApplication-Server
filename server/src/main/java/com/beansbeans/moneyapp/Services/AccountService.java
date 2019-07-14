package com.beansbeans.moneyapp.Services;

import com.beansbeans.moneyapp.Model.Account;
import com.beansbeans.moneyapp.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;


    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public Account create(Account account){
        return accountRepository.save(account);
    }

    public Account show(Long id){
        return accountRepository.findById(id).get();
    }
}
