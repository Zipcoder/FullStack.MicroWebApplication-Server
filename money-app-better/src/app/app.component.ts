import { Component, OnInit } from '@angular/core';
import { User } from '../model/user'
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'Money Managing App';
  loggedIn: boolean;
  currentUser: User;

  caleb: User = {
    id: '3',
    firstName: 'Caleb',
    lastName: 'Powell',
    userName: 'z',
    passwordHash: 'z',
    email: 'z'
  }

  currentPage: string = 'withdraw';

  constructor(private userService: UserService){
  }

  ngOnInit() {
    this.loggedIn = this.userService.loggedIn;
    // this.toggleLogin();
    // this.userService.setUser(this.caleb);
  }

  toggleLogin(){
    if(this.loggedIn){
      this.loggedIn = false;
      this.currentUser = null;
      this.userService.clearUser();
    } else {
      this.loggedIn = true;
      this.currentUser = this.caleb;
      this.userService.setUser(this.caleb);
    }
  }

  setCurrentPage(newPage: string){
    this.currentPage = newPage;
  }
}
