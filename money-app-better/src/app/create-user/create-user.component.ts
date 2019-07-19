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
    const emailstring: string = (document.getElementById('email') as HTMLInputElement).value;
    const passwordstring: string = (document.getElementById('password') as HTMLInputElement).value;
    const firstName: string = (document.getElementById('first') as HTMLInputElement).value;
    const lastName: string = (document.getElementById('last') as HTMLInputElement).value;
    const userName: string = (document.getElementById('user') as HTMLInputElement).value;
    this.user = {id: '',
    firstName,
    lastName,
    userName,
    passwordHash: passwordstring,
    email: emailstring};

    this.userService.createUser(this.user);
    }
  }
