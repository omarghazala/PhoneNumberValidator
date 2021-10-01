import { Component, OnInit } from '@angular/core';
import { Country } from 'src/app/common/country';
import { Listing } from 'src/app/common/listing';
import { CountryService } from 'src/app/services/country.service';
import { PhoneNumberService } from 'src/app/services/phone-number.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-validator-form',
  templateUrl: './validator-form.component.html',
  styleUrls: ['./validator-form.component.css']
})
export class ValidatorFormComponent implements OnInit {

  countries: Country[]=[];
  listing!:Listing;
  formData!: FormGroup;
  
  //listing!:Listing;
  
  
  
  constructor(private countryService:CountryService,
              private phoneNumberService:PhoneNumberService,
              private formBuilder: FormBuilder,
              private router:Router) { 
              
                this.formData = this.formBuilder.group({
                  id: '',
                  number: '',
                  code:''
                });
              }

  

  ngOnInit(): void {

    this.listCountriesCodes()
  }

  listCountriesCodes(){
    
    this.countryService.getCountries().subscribe(
      data=>{
        this.countries = data;
      }
    )
    
  }

  

  onSubmit(){
    this.addNewListing(this.formData)

  }

  addNewListing(formData:FormGroup){
    this.listing = new Listing(formData.value)
    this.phoneNumberService.addPhoneNumber(this.listing).subscribe(list =>{
    });

    this.router.navigate(['/addList'])
  }

}
