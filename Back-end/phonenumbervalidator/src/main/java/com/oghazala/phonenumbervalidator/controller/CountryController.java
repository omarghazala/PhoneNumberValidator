package com.oghazala.phonenumbervalidator.controller;

import com.oghazala.phonenumbervalidator.Service.CountryService;
import com.oghazala.phonenumbervalidator.dto.CountryDTO;
import com.oghazala.phonenumbervalidator.entity.Country;
import com.oghazala.phonenumbervalidator.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin("http://localhost:4200")
public class CountryController {
    @Autowired
    CountryService countryService;

    @RequestMapping(value="readCountries", method = RequestMethod.GET)
    public List<CountryDTO> readCountries(){
        try{
            return countryService.readCountries();
        }
        catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Countries Not Found", exc);
        }

    }

    @RequestMapping(value="createCountry", method = RequestMethod.POST)
    public String createCountry(@RequestBody CountryDTO country){

        try{
            return countryService.createCountry(country);
        }
        catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Country is not created", exc);
        }

    }

    @RequestMapping(value="updateCountry", method = RequestMethod.PUT)
    public String updateCountry(@RequestBody CountryDTO country){
        try{
            return countryService.updateCountry(country);
        }
        catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Country is not updated", exc);
        }

    }

    @RequestMapping(value="deleteCountry", method = RequestMethod.DELETE)
    public String  deleteCountry(@RequestParam("id") Integer id){
        try{
            return countryService.deleteCountry(id);
        }
        catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Country is not deleted", exc);
        }

    }
}
