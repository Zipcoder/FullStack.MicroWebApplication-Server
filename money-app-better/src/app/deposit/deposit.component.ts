import { Component, OnInit } from '@angular/core';
import { User } from 'src/model/user';

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent implements OnInit {

  user: User;

  constructor(private transactionService: TransactionService) { }

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

    this.transactionService.depositTo(this.user.id, deposit);


}
}
