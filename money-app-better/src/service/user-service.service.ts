import { Injectable } from '@angular/core';
import { User } from 'src/model/user';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Account } from '../model/account';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private userUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

public createUser(user: User): Observable<User> {
  return this.http.post<User>(this.userUrl + '/users', user);


}





}
