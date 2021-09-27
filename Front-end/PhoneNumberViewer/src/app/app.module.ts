import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { BodyComponent } from './components/body/body.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http'
import { PhoneNumberService } from './services/phone-number.service';
import { PhoneNumbersListComponent } from './components/phone-numbers-list/phone-numbers-list.component';
import { Routes,RouterModule}  from '@angular/router';
import { PhoneNumber } from './common/phone-number';
import { CountryMenuComponent } from './components/country-menu/country-menu.component';
import { CountryService } from './services/country.service';
const routes: Routes =[
  {path:'country/:id',component:PhoneNumbersListComponent},
  {path:'country/',component:PhoneNumbersListComponent},
  {path:'phoneNumbers',component:PhoneNumbersListComponent},
  {path:'',redirectTo:'phoneNumbers',pathMatch:'full'},
  {path:'**',redirectTo:'phoneNumbers',pathMatch:'full'}
]
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    BodyComponent,
    PhoneNumbersListComponent,
    CountryMenuComponent,
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule
  ],
  providers: [PhoneNumberService,CountryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
