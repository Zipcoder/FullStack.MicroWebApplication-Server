import { Component, OnInit } from '@angular/core';
import { Account } from '../model/account';
import { ACCOUNTS } from '../mock-accounts';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-acc-transfer',
  templateUrl: './acc-transfer.component.html',
  styleUrls: ['./acc-transfer.component.css']
})
export class AccTransferComponent implements OnInit {

  usersAsString: string = "fuck it";
  accounts: Account[];
  
  fromAccount: Account;
  fromId: number;
  toAccount: Account;
  toId: number;
  amountToTransfer: number = 0;

  constructor(private accountService: AccountService) { }

  ngOnInit() {
    this.getAccounts();
  }

  onSelectFrom(account: Account){
    this.fromAccount = account;
    this.fromId = account.id;
  }

  onSelectTo(account: Account){
    this.toAccount = account;
    this.toId = account.id;
  }

  getAccounts(): void{
    this.accountService.getAll().subscribe(accounts => this.accounts = accounts);
  }

  transfer(): void{
    let updatedFromAccount: Account = {id: this.fromAccount.id, 
      balance: this.fromAccount.balance - +this.amountToTransfer, 
      userid: this.fromAccount.userid};

    let updatedToAccount: Account = {id: this.toAccount.id, 
      balance: this.toAccount.balance + +this.amountToTransfer,
      userid: this.toAccount.userid};

      console.log(updatedToAccount.balance);

    this.accountService.update(updatedFromAccount).subscribe();
    this.accountService.update(updatedToAccount).subscribe();
    this.getAccounts();
  }


}
