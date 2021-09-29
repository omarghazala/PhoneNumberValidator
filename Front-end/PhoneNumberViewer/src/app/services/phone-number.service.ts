import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PhoneNumber } from '../common/phone-number';
import { map } from 'rxjs/operators';
import { Country } from '../common/country';
import { Listing } from '../common/listing';

@Injectable({
  providedIn: 'root'
})
export class PhoneNumberService {

  private phoneNumbersUrl = "http://localhost:8080/api/phoneNumbers";
  private phoneNumbersCountriesUrl = "http://localhost:8080/api";
  

  constructor(private httpCLient:HttpClient) {
  }

  // getAllPhoneNumbers():Observable<PhoneNumber[]>{
  //   return this.httpCLient.get<GetResponsePhoneNumber>(this.phoneNumbersUrl).pipe(
  //     map(response =>response._embedded.phoneNumbers)
  //   )
  // }

  getAllPhoneNumbers():Observable<Listing[]>{
    return this.httpCLient.get<Listing[]>(`${this.phoneNumbersCountriesUrl}/readPhoneNumbers`)
    
  }

  getPhoneNumbers(theCountryId:number):Observable<Listing[]>{

    const searchUrl = `${this.phoneNumbersCountriesUrl}/readPhoneNumberByCountryId?countryId=${theCountryId}`;
    return this.httpCLient.get<Listing[]>(searchUrl)
  }

  
  
  // getPhoneNumbers(theCountryId:number):Observable<PhoneNumber[]>{

  //   const searchUrl = `${this.phoneNumbersUrl}/search/findByCountryId?id=${theCountryId}`;

  //   return this.httpCLient.get<GetResponsePhoneNumber>(searchUrl).pipe(
  //     map(response =>response._embedded.phoneNumbers)
  //   )
  // }

  getPhoneNumbersState(theState:string):Observable<PhoneNumber[]>{

    const searchUrl = `${this.phoneNumbersCountriesUrl}/readPhoneNumberByNumberState?numberState=${theState}`;

    return this.httpCLient.get<Listing[]>(searchUrl);
    
  }

  // getPhoneNumbersState(theState:string):Observable<PhoneNumber[]>{

  //   const searchUrl = `${this.phoneNumbersUrl}/search/findByNumberState?state=${theState}`;

  //   return this.httpCLient.get<GetResponsePhoneNumber>(searchUrl).pipe(
  //     map(response =>response._embedded.phoneNumbers)
  //   )
  // }


}




// interface GetResponsePhoneNumber{
//   _embedded:{
//     phoneNumbers:PhoneNumber[]
//   }
// }

