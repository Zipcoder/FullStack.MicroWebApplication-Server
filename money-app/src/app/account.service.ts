import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Account } from './model/account';

@Injectable()
export class AccountService {
  private accountsURL: string;

  constructor(private http: HttpClient) {
    this.accountsURL = "http://192.168.3.143:9065/accounts";
  }

  public getAll(): Observable<Account[]> {
    //return  this.http.get('mysql://kmmwdvl9gxkn00qv:jtgxnrgznd4ikziq@z37udk8g6jiaqcbx.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/ht7vcw1fdlysxgp8');
    return this.http.get<Account[]>(this.accountsURL);
  }

  public update(account: Account){
    return this.http.put<Account>(this.accountsURL + "/" + account.id, account);
  }
}
