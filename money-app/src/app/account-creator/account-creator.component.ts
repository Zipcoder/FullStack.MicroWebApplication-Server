import { Component, OnInit } from '@angular/core';
import { User } from "../model/user"


@Component({
  selector: 'app-account-creator',
  templateUrl: './account-creator.component.html',
  styleUrls: ['./account-creator.component.css']
})
export class AccountCreatorComponent implements OnInit {

  title: string;
  user: User = {
    id: 123,
    firstName: 'something',
    lastName: 'else'
  };

  constructor() {
    this.title = 'hello';
  }

  ngOnInit() {
  }

}
