import { Component, OnInit } from '@angular/core';
import { Country } from 'src/app/common/country';
import { CountryService } from 'src/app/services/country.service';
import { PhoneNumberService } from 'src/app/services/phone-number.service';

@Component({
  selector: 'app-country-menu',
  templateUrl: './country-menu.component.html',
  styleUrls: ['./country-menu.component.css']
})
export class CountryMenuComponent implements OnInit {

  countries: Country[]=[];
  states:number[]=[];

  constructor(private phoneNumberService:PhoneNumberService,private countryService:CountryService) { }

  ngOnInit(): void {
    this.listCountriesCategories();
  }

  listCountriesCategories(){
    
    this.countryService.getCountries().subscribe(
      data=>{
        this.countries = data;
      }
    )
    
  }


  

  
}
