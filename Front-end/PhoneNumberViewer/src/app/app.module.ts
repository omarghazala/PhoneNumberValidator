import { ErrorHandler, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule,HTTP_INTERCEPTORS } from '@angular/common/http'
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
import { ServerDownPageComponent } from './components/server-down-page/server-down-page.component';
import { ClearFilterMenuComponent } from './components/clear-filter-menu/clear-filter-menu.component';
import { GlobalErrorHandlerService } from './services/global-error-handler.service';
import { GloblaHttpInterceptorService } from './services/globla-http-interceptor.service';
import { AddFailPageComponent } from './components/add-fail-page/add-fail-page.component';
import { BackToFormComponent } from './components/back-to-form/back-to-form.component';


const routes: Routes =[
  {path:'country/:id',component:PhoneNumbersListComponent},
  {path:'phoneNumbers/:state',component:PhoneNumbersListComponent},
  {path:'country/',component:PhoneNumbersListComponent},
  {path:'phoneNumbers',component:PhoneNumbersListComponent},
  {path:'addList',component:PhoneNumbersListComponent},
  {path:'clearFilter',component:PhoneNumbersListComponent},
  {path:'serverDown',component:ServerDownPageComponent},
  {path:'addFail',component:AddFailPageComponent},
  {path:'validatorForm',component:ValidatorFormComponent},
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
    ValidatorFormComponent,
    ServerDownPageComponent,
    ClearFilterMenuComponent,
    AddFailPageComponent,
    BackToFormComponent
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
  providers: [
    PhoneNumberService,
    CountryService,
    { provide: HTTP_INTERCEPTORS,    useClass: GloblaHttpInterceptorService,    multi: true  },
    { provide: ErrorHandler, useClass:GlobalErrorHandlerService} 
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
