package com.beansbeans.moneyapp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;
    private Long fromAccountId;
    private Long toAccountId;
    private Double amount;
    private String memo;
    private LocalDateTime localDateTime;

    public Transaction() { }

    public Transaction(Long fromAccountId, Long toAccountId, Double amount, String memo, LocalDateTime localDateTime) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.memo = memo;
        this.localDateTime = localDateTime;
    }

    public Transaction(Long transactionId, Long fromAccountId, Long toAccountId, Double amount, String memo, LocalDateTime localDateTime) {
        this.transactionId = transactionId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.memo = memo;
        this.localDateTime = localDateTime;
    }

    public Transaction(Long toAccountId, Double amount) {
        this.toAccountId = toAccountId;
        this.amount = amount;
    }

    public Transaction(Long fromAccountId, String memo) {
        this.fromAccountId = fromAccountId;
        this.memo = memo;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Long getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
