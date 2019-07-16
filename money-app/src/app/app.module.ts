import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccountService } from './account.service';
import { HttpClientModule } from '@angular/common/http';
import { AccountCreatorComponent } from './account-creator/account-creator.component';
import {RouterModule} from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    AccountCreatorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule,
    FormsModule
  ],
  providers: [AccountService],
  bootstrap: [AppComponent]
})
export class AppModule { }
