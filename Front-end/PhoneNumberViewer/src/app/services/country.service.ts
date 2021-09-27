import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Country } from '../common/country';

@Injectable({
  providedIn: 'root'
})
export class CountryService {

  private countriesUrl = "http://localhost:8080/api/countries";
  
  constructor(private httpCLient:HttpClient) { }

  getCountries():Observable<Country[]>{
    return this.httpCLient.get<GetResponseCountries>(this.countriesUrl).pipe(
      map(response =>response._embedded.countries)
  )
  
  
  }

}

interface GetResponseCountries{
  _embedded:{
    countries:Country[]
  }
}