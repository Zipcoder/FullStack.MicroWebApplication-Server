import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DepositComponent } from './deposit/deposit.component';
import { WithdrawComponent } from './withdraw/withdraw.component';
import { AddAccountComponent } from './add-account/add-account.component';
import { DeleteAccountComponent } from './delete-account/delete-account.component';
import { TransactionsComponent } from './transactions/transactions.component';


const routes: Routes = [
  {path: 'deposit', component: DepositComponent},
  {path: 'withdraw', component: WithdrawComponent},
  {path: 'addaccount', component: AddAccountComponent},
  {path: 'deleteaccount', component: DeleteAccountComponent},
  {path: 'transactions', component: TransactionsComponent},
  {path: '', redirectTo: 'deposit', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
