import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AccountService {
private accountsURL: string;

constructor(private http: HttpClient) {}

getAll(): Observable<any> {
  return  this.http.get('mysql://kmmwdvl9gxkn00qv:jtgxnrgznd4ikziq@z37udk8g6jiaqcbx.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/ht7vcw1fdlysxgp8');
}
}
