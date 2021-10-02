import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Listing } from 'src/app/common/listing';
import { PhoneNumber } from 'src/app/common/phone-number';
import { PhoneNumberService } from 'src/app/services/phone-number.service';

@Component({
  selector: 'app-phone-numbers-list',
  templateUrl: './phone-numbers-list.component.html',
  styleUrls: ['./phone-numbers-list.component.css']
})
export class PhoneNumbersListComponent implements OnInit {

  phoneNumbers: PhoneNumber[] =[];
  phoneNumbersCountries: Listing[] =[];
  listing!: Listing;
  currentCountryId!:number;
  currentPhoneNumberState!:string;

  constructor(private phoneNumberService:PhoneNumberService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(()=>{
      this.listPhoneNumbers()
    })
  }

  listPhoneNumbers(){
    const hasCountryId : boolean = this.route.snapshot.paramMap.has('id');
    const hasState : boolean = this.route.snapshot.paramMap.has('state');

    if(hasCountryId){
      this.currentCountryId = +this.route.snapshot.paramMap.get('id')!;
      this.phoneNumberService.getPhoneNumbers(this.currentCountryId).subscribe(
        data => {
          this.phoneNumbersCountries = data
        }
      ) 
    }
    else if (hasState){
      this.currentPhoneNumberState = this.route.snapshot.paramMap.get('state')!;
      this.phoneNumberService.getPhoneNumbersState(this.currentPhoneNumberState).subscribe(
        data => {
          this.phoneNumbersCountries = data
        }
      ) 
    }
    else{
      this.phoneNumberService.getAllPhoneNumbers().subscribe(
        data => {
          this.phoneNumbersCountries = data
          //console.log(data);
        }
      )
    

    
    
   }

 }
}