import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PhoneNumber } from 'src/app/common/phone-number';
import { PhoneNumberService } from 'src/app/services/phone-number.service';

@Component({
  selector: 'app-phone-numbers-list',
  templateUrl: './phone-numbers-list.component.html',
  styleUrls: ['./phone-numbers-list.component.css']
})
export class PhoneNumbersListComponent implements OnInit {

  phoneNumbers: PhoneNumber[] =[];
  currentCountryId!:number;

  constructor(private phoneNumberService:PhoneNumberService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(()=>{
      this.listPhoneNumbers()
    })
  }

  listPhoneNumbers(){
    // check if the id is avaliable
    const hasCountryId : boolean = this.route.snapshot.paramMap.has('id');

    if(hasCountryId){
      this.currentCountryId = +this.route.snapshot.paramMap.get('id')!; 
    }
    else{
      this.currentCountryId = 1;
    }
    this.phoneNumberService.getPhoneNumbers(this.currentCountryId).subscribe(
      data => {
        this.phoneNumbers = data
        console.log(this.phoneNumbers)
      }
    )
  }

}
