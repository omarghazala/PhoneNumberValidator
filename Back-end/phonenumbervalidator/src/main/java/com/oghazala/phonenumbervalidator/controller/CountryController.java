package com.oghazala.phonenumbervalidator.controller;

import com.oghazala.phonenumbervalidator.Service.CountryService;
import com.oghazala.phonenumbervalidator.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
    @Autowired
    CountryService countryService;

    @RequestMapping(value="createCountry", method = RequestMethod.POST)
    public String createCountry(@RequestBody Country country){
        return countryService.createCountry(country);
    }

    @RequestMapping(value="readCountries", method = RequestMethod.GET)
    public List<Country> readCountries(){
        return countryService.readCountries();
    }

    @RequestMapping(value="updateCountry", method = RequestMethod.PUT)
    public String updateCountry(@RequestBody Country country){
        return countryService.updateCountry(country);
    }
    @RequestMapping(value="deleteCountry", method = RequestMethod.DELETE)
    public String  deleteCountry(@RequestBody Country country){
        return countryService.deleteCountry(country);
    }
}
