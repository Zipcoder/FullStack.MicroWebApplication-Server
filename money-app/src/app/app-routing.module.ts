import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AccDepositComponent } from './acc-deposit/acc-deposit.component';
import { UserManagementComponent } from './user-management/user-management.component';
import { AccWithdrawComponent } from './acc-withdraw/acc-withdraw.component';
import { AccTransferComponent } from './acc-transfer/acc-transfer.component';


const routes: Routes = [
  {path: 'users', component: UserManagementComponent},
  {path: 'deposit', component: AccDepositComponent},
  {path: 'withdraw', component: AccWithdrawComponent},
  {path: 'transfer', component: AccTransferComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [AccDepositComponent,
  UserManagementComponent,
  AccWithdrawComponent,
  AccTransferComponent];