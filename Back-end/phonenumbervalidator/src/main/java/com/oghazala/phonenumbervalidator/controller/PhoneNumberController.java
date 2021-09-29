package com.oghazala.phonenumbervalidator.controller;

import com.oghazala.phonenumbervalidator.Service.CountryService;
import com.oghazala.phonenumbervalidator.Service.PhoneNumberService;
import com.oghazala.phonenumbervalidator.dto.ListingDTO;
import com.oghazala.phonenumbervalidator.dto.PhoneNumberDTO;
import com.oghazala.phonenumbervalidator.entity.Country;
import com.oghazala.phonenumbervalidator.entity.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin("http://localhost:4200")
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

    @RequestMapping(value="readPhoneNumbers", method = RequestMethod.GET)
    public List<ListingDTO> readPhoneNumbers(){
        return phoneNumberService.readPhoneNumbers();
    }

    @RequestMapping(value="readPhoneNumberByCountryId", method = RequestMethod.GET)
    public List<ListingDTO> readPhoneNumberByCountryId(@RequestParam Long countryId){
        return phoneNumberService.readPhoneNumberByCountryId(countryId);
    }

    @RequestMapping(value="readPhoneNumberByNumberState", method = RequestMethod.GET)
    public List<ListingDTO> readPhoneNumberByNumberState(@RequestParam String numberState){
        return phoneNumberService.readPhoneNumberByNumberState(numberState);
    }

    @RequestMapping(value="createPhoneNumber", method = RequestMethod.POST)
    public String createPhoneNumber(@RequestBody PhoneNumberDTO phoneNumber){
        return phoneNumberService.createPhoneNumber(phoneNumber);
    }

    @RequestMapping(value="updatePhoneNumber", method = RequestMethod.PUT)
    public String updatePhoneNumber(@RequestBody PhoneNumberDTO phoneNumber){
        return phoneNumberService.updatePhoneNumber(phoneNumber);
    }
    @RequestMapping(value="deletePhoneNumber", method = RequestMethod.DELETE)
    public String  deletePhoneNumber(@RequestBody PhoneNumberDTO phoneNumber){
        return phoneNumberService.deletePhoneNumber(phoneNumber);
    }





}
