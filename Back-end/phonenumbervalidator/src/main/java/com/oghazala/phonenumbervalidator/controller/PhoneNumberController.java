package com.oghazala.phonenumbervalidator.controller;

import com.oghazala.phonenumbervalidator.Service.CountryService;
import com.oghazala.phonenumbervalidator.Service.PhoneNumberService;
import com.oghazala.phonenumbervalidator.dto.ListingDTO;
import com.oghazala.phonenumbervalidator.dto.PhoneNumberDTO;
import com.oghazala.phonenumbervalidator.entity.Country;
import com.oghazala.phonenumbervalidator.entity.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin("http://localhost:4200")
public class PhoneNumberController {
    @Autowired
    PhoneNumberService phoneNumberService;

    @RequestMapping(value="readPhoneNumbers", method = RequestMethod.GET)
    public List<ListingDTO> readPhoneNumbers(){
        try{
            return phoneNumberService.readPhoneNumbers();
        }
        catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Phone numbers are not found", exc);
        }

    }

    @RequestMapping(value="readPhoneNumberByCountryId", method = RequestMethod.GET)
    public List<ListingDTO> readPhoneNumberByCountryId(@RequestParam Integer countryId){
        try{
            return phoneNumberService.readPhoneNumberByCountryId(countryId);
        }
        catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND," Phone number is not found", exc);
        }

    }

    @RequestMapping(value="readPhoneNumberByNumberState", method = RequestMethod.GET)
    public List<ListingDTO> readPhoneNumberByNumberState(@RequestParam String numberState){
        try{
            return phoneNumberService.readPhoneNumberByNumberState(numberState);
        }
        catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Phone number is not found", exc);
        }

    }
    @RequestMapping(value="readCount", method = RequestMethod.GET)
    public Long readCount(){
        try{
            return phoneNumberService.readCount();
        }
        catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "count not triggered", exc);
        }

    }
    @RequestMapping(value="createPhoneNumber", method = RequestMethod.POST)
    public String createPhoneNumber(@RequestBody ListingDTO listingDTO){
        try{
            return phoneNumberService.createPhoneNumber(listingDTO);
        }
        catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Phone number is not created", exc);
        }

    }

    @RequestMapping(value="updatePhoneNumber", method = RequestMethod.PUT)
    public String updatePhoneNumber(@RequestBody PhoneNumberDTO phoneNumber){
        try{
            return phoneNumberService.updatePhoneNumber(phoneNumber);
        }
        catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Phone number is not updated", exc);
        }

    }
    @RequestMapping(value="deletePhoneNumber", method = RequestMethod.DELETE)
    public String  deletePhoneNumber(@RequestBody PhoneNumberDTO phoneNumber){
        try{
            return phoneNumberService.deletePhoneNumber(phoneNumber);
        }
        catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Phone number is not deleted", exc);
        }

    }





}
