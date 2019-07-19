import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  depositFunds(): void {
    let deposit: number = Number((document.getElementById('deposit') as HTMLInputElement).value);


    // this.user = {id: '',
    // firstName: firstName,
    // lastName: lastName,
    // userName: userName,
    // passwordHash: passwordstring,
    // email: emailstring};

    // this.TransactionService.depositTo(id, deposit);


}
}