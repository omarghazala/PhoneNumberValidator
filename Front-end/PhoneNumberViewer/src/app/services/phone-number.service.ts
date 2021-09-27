import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PhoneNumber } from '../common/phone-number';
import { map } from 'rxjs/operators';
import { Country } from '../common/country';

@Injectable({
  providedIn: 'root'
})
export class PhoneNumberService {

  private phoneNumbersUrl = "http://localhost:8080/api/phoneNumbers";
  

  constructor(private httpCLient:HttpClient) {
  }

  getPhoneNumbers(theCountryId:number):Observable<PhoneNumber[]>{

    const searchUrl = `${this.phoneNumbersUrl}/search/findByCountryId?id=${theCountryId}`;

    return this.httpCLient.get<GetResponsePhoneNumber>(searchUrl).pipe(
      map(response =>response._embedded.phoneNumbers)
    )
  }


}




interface GetResponsePhoneNumber{
  _embedded:{
    phoneNumbers:PhoneNumber[]
  }
}
