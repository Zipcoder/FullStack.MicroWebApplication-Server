import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-account-creator',
  templateUrl: './account-creator.component.html',
  styleUrls: ['./account-creator.component.css']
})
export class AccountCreatorComponent implements OnInit {

  constructor(private location: Location) { }

  ngOnInit() {
  }

}
