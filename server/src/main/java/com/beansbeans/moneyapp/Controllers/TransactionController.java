package com.beansbeans.moneyapp.Controllers;

import com.beansbeans.moneyapp.Model.Transaction;
import com.beansbeans.moneyapp.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@CrossOrigin
@RequestMapping(path="/api")
@Transactional
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transaction")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction){
        return new ResponseEntity<>(transactionService.newTransaction(transaction), HttpStatus.OK);
    }

    @GetMapping("/transaction/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable Long id){
        return new ResponseEntity<>(transactionService.findTransactionById(id), HttpStatus.OK);
    }

    @GetMapping("/transaction/{userId}")
    public ResponseEntity<Transaction> findByUserId(@PathVariable Long userId){
        return new ResponseEntity<>(transactionService.findTransactionByUserId(userId), HttpStatus.OK);
    }


    @GetMapping("/transaction")
    public ResponseEntity<Iterable<Transaction>> getAllTransactions(){
        return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
    }

    @PostMapping("/transaction/deposit")
    public ResponseEntity<Boolean> deposit(@PathVariable Long toAccountId, @RequestBody Double amount){
        return new ResponseEntity<>(transactionService.depositTo(toAccountId, amount), HttpStatus.OK);
    }

    @PostMapping("/transaction/withdraw")
    public ResponseEntity<Boolean> withdraw(@PathVariable Long fromAccountId, @RequestBody Double amount){
        return new ResponseEntity<>(transactionService.withdrawFrom(fromAccountId, amount), HttpStatus.OK);
    }

    @PostMapping("/transaction/transfer")
    public ResponseEntity<Boolean> transfer(@RequestBody Transaction transaction){
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        Long fromAccountId = transaction.getFromAccountId();
        Long toAccountId = transaction.getToAccountId();
        Double amount = transaction.getAmount();
        return new ResponseEntity<>(transactionService.transferFunds(fromAccountId, toAccountId, amount), HttpStatus.OK);
    }
}
