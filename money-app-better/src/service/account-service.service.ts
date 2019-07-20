import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Account } from '../model/account';

@Injectable({
  providedIn: 'root'
})
export class AccountServiceService {
  accountUrl: string;
  constructor(private http:HttpClient) { 
    // this.accountUrl = "http://moneyapp-env.njfvb73f7f.us-east-2.elasticbeanstalk.com/api/accounts";
    // this.accountUrl = "http://localhost:6969/api/accounts";
    //this.accountUrl = "http://localhost:8076/api/accounts";
    // this.accountUrl = 'MoneyApp-env.njfvb73f7f.us-east-2.elasticbeanstalk.com/accounts';
  }

  public getAccount(): Observable<Account>{
    return this.http.get<Account>(this.accountUrl + "/1")
  }

  public getAccounts(): Observable<Account[]>{
    return this.http.get<Account[]>("/proxy/api/accounts");
  }

  public getAccountsByUser(userid: string): Observable<Account[]>{
    return this.http.get<Account[]>("/proxy/api/accounts/user/" + userid);
  }
}
