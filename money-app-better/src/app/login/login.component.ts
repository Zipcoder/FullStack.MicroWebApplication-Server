import { Component, OnInit, Input } from '@angular/core';
import { User } from 'src/model/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  emailString = 'what is in the email field will go here when you press test';

  @Input('loginStatus') loggedIn: boolean;

  user: User;

  constructor() { }

  ngOnInit() {
  }
login(): void {
  const emailstring: string = (document.getElementById('emailLogin') as HTMLInputElement).value;
  const passwordstring: string = (document.getElementById('passwordLogin') as HTMLInputElement).value;

  this.user = {id: '',
  firstName: '',
  lastName: '',
  userName: '',
  passwordHash: passwordstring,
  email: emailstring};

// next line needs to be directed to correct method for user login
// this.userService.createUser(this.user);
}

}
