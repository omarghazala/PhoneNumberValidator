import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { PhoneNumber } from '../common/phone-number';
import { catchError, map } from 'rxjs/operators';
import { Country } from '../common/country';
import { Listing } from '../common/listing';

@Injectable({
  providedIn: 'root'
})
export class PhoneNumberService {

  
  private phoneNumbersCountriesUrl = "http://localhost:8080/api";
  
  constructor(private httpCLient:HttpClient) {
  }

  addPhoneNumber(listing:Listing):Observable<any>{
    const headers = { 'content-type': 'application/json'}  
    listing.number= listing.number?.toString();
    const body=JSON.stringify(listing);
    //console.log(number)
    console.log(body)
    return this.httpCLient.post(`${this.phoneNumbersCountriesUrl}/createPhoneNumber`,body,{headers:headers})
  }


  getCount():Observable<number>{
    return this.httpCLient.get<number>(`${this.phoneNumbersCountriesUrl}/readCount`).pipe(
      catchError((err)=>{
        console.log('error caught in counting')
        console.error(err);
        return throwError(err);
      })
    )
    
  }

  
  
  getAllPhoneNumbers():Observable<Listing[]>{
    return this.httpCLient.get<Listing[]>(`${this.phoneNumbersCountriesUrl}/readPhoneNumbers`).pipe(
      catchError((err)=>{
        console.log('error caught in service')
        console.error(err);
        return throwError(err);
      })
    )
    
  }

  getPhoneNumbers(theCountryId:number):Observable<Listing[]>{

    const searchUrl = `${this.phoneNumbersCountriesUrl}/readPhoneNumberByCountryId?countryId=${theCountryId}`;
    return this.httpCLient.get<Listing[]>(searchUrl)
  }

  getPhoneNumbersState(theState:string):Observable<PhoneNumber[]>{

    const searchUrl = `${this.phoneNumbersCountriesUrl}/readPhoneNumberByNumberState?numberState=${theState}`;

    return this.httpCLient.get<Listing[]>(searchUrl);
    
  }

}
