import { Injectable } from '@angular/core';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  currentUser: User;

  constructor() { }

  getUser(): User{
    return this.currentUser;
  }

  setUser(user: User){
    this.currentUser = user;
  }

  clearUser(){
    delete this.currentUser;
  }
}
