package com.beansbeans.moneyapp.Controllers;

import com.beansbeans.moneyapp.Model.Account;
import com.beansbeans.moneyapp.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/accounts")
    public ResponseEntity<Account> create(@RequestBody Account account){
        return new ResponseEntity<>(accountService.create(account), HttpStatus.CREATED);
    }

    @GetMapping("/accounts")
    public ResponseEntity<Iterable<Account>> findAllAccounts(){
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> getById(@PathVariable Long id){
        return new ResponseEntity<>(accountService.show(id), HttpStatus.OK);
    }

    @PutMapping("/accounts/{id}")
    public ResponseEntity<Account> updateBalance(@PathVariable Long id, @RequestBody Account account){
        return new ResponseEntity<>(accountService.updateBalance(id, account), HttpStatus.OK);
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<Boolean> deleteAccount(@PathVariable Long id){
        return new ResponseEntity<>(accountService.deleteAccount(id), HttpStatus.OK);
    }

}
