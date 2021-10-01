import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http'
import { PhoneNumberService } from './services/phone-number.service';
import { PhoneNumbersListComponent } from './components/phone-numbers-list/phone-numbers-list.component';
import { Routes,RouterModule}  from '@angular/router';
import { PhoneNumber } from './common/phone-number';
import { CountryMenuComponent } from './components/country-menu/country-menu.component';
import { CountryService } from './services/country.service';
import { StateMenuComponent } from './components/state-menu/state-menu.component';
import { FilterMenuComponent } from './components/filter-menu/filter-menu.component';
import { ValidatorFormComponent } from './components/validator-form/validator-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

const routes: Routes =[
  {path:'country/:id',component:PhoneNumbersListComponent},
  {path:'phoneNumbers/:state',component:PhoneNumbersListComponent},
  {path:'country/',component:PhoneNumbersListComponent},
  {path:'phoneNumbers',component:PhoneNumbersListComponent},
  {path:'addToList',component:PhoneNumbersListComponent},
  {path:'',redirectTo:'phoneNumbers',pathMatch:'full'},
  {path:'**',redirectTo:'phoneNumbers',pathMatch:'full'}
]
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    PhoneNumbersListComponent,
    CountryMenuComponent,
    StateMenuComponent,
    FilterMenuComponent,
    ValidatorFormComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [PhoneNumberService,CountryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
