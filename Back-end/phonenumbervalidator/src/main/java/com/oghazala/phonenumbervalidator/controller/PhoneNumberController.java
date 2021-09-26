package com.oghazala.phonenumbervalidator.controller;

import com.oghazala.phonenumbervalidator.Service.CountryService;
import com.oghazala.phonenumbervalidator.Service.PhoneNumberService;
import com.oghazala.phonenumbervalidator.entity.Country;
import com.oghazala.phonenumbervalidator.entity.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhoneNumberController {
    @Autowired
    PhoneNumberService phoneNumberService;

    @RequestMapping(value = "", method = RequestMethod.GET )
    public String home(){
        return "home app is up..";
    }
    @RequestMapping(value = "info", method = RequestMethod.GET )
    public String info(){
        return "info app is up..";
    }

    @RequestMapping(value="createPhoneNumber", method = RequestMethod.POST)
    public String createCountry(@RequestBody PhoneNumber phoneNumber){
        return phoneNumberService.createPhoneNumber(phoneNumber);
    }

    @RequestMapping(value="readPhoneNumbers", method = RequestMethod.GET)
    public List<PhoneNumber> readCountries(){
        return phoneNumberService.readPhoneNumbers();
    }

    @RequestMapping(value="updatePhoneNumber", method = RequestMethod.PUT)
    public String updateCountry(@RequestBody PhoneNumber phoneNumber){
        return phoneNumberService.updateCountry(phoneNumber);
    }
    @RequestMapping(value="deletePhoneNumber", method = RequestMethod.DELETE)
    public String  deleteCountry(@RequestBody PhoneNumber phoneNumber){
        return phoneNumberService.deleteCountry(phoneNumber);
    }
}
