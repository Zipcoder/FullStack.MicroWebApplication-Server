import { Component, OnInit } from '@angular/core';
import { User } from '../model/user'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'Money Managing App';
  loggedIn: boolean = false;
  currentUser: User;

  caleb: User = {
    id: '123',
    firstName: 'Caleb',
    lastName: 'Powell'
  }

  constructor(){
  }

  ngOnInit() {
    this.toggleLogin();
  }

  toggleLogin(){
    if(this.loggedIn){
      this.loggedIn = false;
      this.currentUser = null;
    } else {
      this.loggedIn = true;
      this.currentUser = this.caleb;
    }
  }
}
