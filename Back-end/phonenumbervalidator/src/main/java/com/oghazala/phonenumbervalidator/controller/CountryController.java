package com.oghazala.phonenumbervalidator.controller;

import com.oghazala.phonenumbervalidator.Service.CountryService;
import com.oghazala.phonenumbervalidator.dto.CountryDTO;
import com.oghazala.phonenumbervalidator.entity.Country;
import com.oghazala.phonenumbervalidator.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin("http://localhost:4200")
public class CountryController {
    @Autowired
    CountryService countryService;

    @RequestMapping(value="readCountries", method = RequestMethod.GET)
    public List<CountryDTO> readCountries(){
        return countryService.readCountries();
    }

    @RequestMapping(value="createCountry", method = RequestMethod.POST)
    public String createCountry(@RequestBody CountryDTO country){
        return countryService.createCountry(country);
    }

    @RequestMapping(value="updateCountry", method = RequestMethod.PUT)
    public String updateCountry(@RequestBody CountryDTO country){
        return countryService.updateCountry(country);
    }

    @RequestMapping(value="deleteCountry", method = RequestMethod.DELETE)
    public String  deleteCountry(@RequestParam("id") Integer id){
        return countryService.deleteCountry(id);
    }
}
