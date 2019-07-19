import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  emailString: string = "what is in the email field will go here when you press test";

  @Input('loginStatus') loggedIn: boolean;

  constructor() { }

  ngOnInit() {
  }

  login():void{
    this.emailString = (<HTMLInputElement>document.getElementById("email")).value;
  }

}