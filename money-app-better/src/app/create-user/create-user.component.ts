import { Component, OnInit, Input } from '@angular/core';
import { User } from 'src/model/user';
import {UserServiceService} from '../../service/user-service.service';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  @Input('loginStatus') loggedIn: boolean;

user: User;

  constructor(private userService: UserServiceService) { }

  ngOnInit() {
  }
  createUser(): void {
    let emailstring: string = (document.getElementById('email') as HTMLInputElement).value;
    let passwordstring: string = (document.getElementById('password') as HTMLInputElement).value;
    let firstName: string = (document.getElementById('first') as HTMLInputElement).value;
    let lastName: string = (document.getElementById('last') as HTMLInputElement).value;
    let userName: string = (document.getElementById('user') as HTMLInputElement).value;
 
    this.user = {id: '',
    firstName: firstName,
    lastName: lastName,
    userName: userName,
    passwordHash: passwordstring,
    email: emailstring};

    this.userService.createUser(this.user);
    }
  }