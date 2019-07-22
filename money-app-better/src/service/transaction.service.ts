import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Transaction } from '../model/transaction';
import { DepositAccount } from '../model/depositAccount';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  transactionUrl: string;

  constructor(private http: HttpClient) {
    this.transactionUrl = 'http://moneyapp-env.njfvb73f7f.us-east-2.elasticbeanstalk.com/transactions';
  }

  public transfer(fromAccountId: number, toAccountId: number, amount: number, userId: number): Observable<any> {
    const transaction: Transaction = {fromAccountId, toAccountId,
       amount, memo: 'this space left blank', userId};
    return this.http.post(this.transactionUrl + '/transaction/transfer', transaction);
  }
  public deposit(toAccountId: number, amount: number, userId: number): Observable<any> {
    const depositAccount: DepositAccount = {toAccountId, amount, memo: 'this space left blank', userId};
    return this.http.post(this.transactionUrl + '/transaction/transfer', depositAccount);
  }
}
