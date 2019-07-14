package com.beansbeans.moneyapp.Controllers;

import com.beansbeans.moneyapp.Model.Transaction;
import com.beansbeans.moneyapp.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

//    @PostMapping("/transaction")
//    public ResponseEntity<Transaction>
}
