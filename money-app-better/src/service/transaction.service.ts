import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Transaction } from '../model/transaction';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  transactionUrl: string;

  constructor(private http: HttpClient) { 
    this.transactionUrl="http://localhost:9065/transactions";
  }

  public transfer(fromAccountId:number, toAccountId: number, amount: number): Observable<any>{
    let transaction: Transaction = {fromAccountId:fromAccountId, toAccountId:toAccountId, amount:amount};
    return this.http.post(this.transactionUrl + "/transaction/transfer", transaction);
  }
}
