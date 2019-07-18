import { Component, OnInit } from '@angular/core';
import { Account } from '../../model/account';
import { AccountServiceService } from '../../service/account-service.service';

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {

  account: Account;
  accounts: Account[];
  currentAccount: Account;

  constructor(private accountServiceService: AccountServiceService) {
  }

  ngOnInit() {
    this.getAccounts();
  }

  updateAccount(){
    this.accountServiceService.getAccount().subscribe(account => this.account = account);
  }

  getAccounts(){
    this.accountServiceService.getAccounts().subscribe(accounts => this.accounts = accounts);
  }

  setCurrentAccount(acc: Account): void{
    this.currentAccount = acc;
  }

  clearAccount(): void{
    delete this.currentAccount;
  }

}
