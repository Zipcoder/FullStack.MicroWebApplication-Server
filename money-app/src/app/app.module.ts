import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccountService } from './account.service';
import { HttpClientModule } from '@angular/common/http';
import { AccountCreatorComponent } from './account-creator/account-creator.component';

@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    AccountCreatorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [AccountService],
  bootstrap: [AppComponent]
})
export class AppModule { }
