package com.oghazala.phonenumbervalidator.Service;

import com.oghazala.phonenumbervalidator.entity.Country;
import com.oghazala.phonenumbervalidator.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public String createCountry(Country country){
        if(!countryRepository.existsByCode(country.getCode())){
            countryRepository.save(country);
            return "country saved";
        }
        else{
            return "country already exists";
        }
    }


    public List<Country> readCountries(){
        return countryRepository.findAll();
    }

    @Transactional
    public String updateCountry(Country country){
        if(countryRepository.existsByCode(country.getCode())){
            List<Country> countries = countryRepository.findByCode(country.getCode());
            //Country countryToBeUpdated = countryRepository.findById(country.getId());
            countries.forEach(countryToBeUpdated->{
                countryToBeUpdated.setId(country.getId());
                countryToBeUpdated.setName(country.getName());
                countryToBeUpdated.setCode(country.getCode());
                countryToBeUpdated.setRegex(country.getRegex());
            });

            return "country updated";
        }
        else{
            return "country no found";
        }
    }

    @Transactional
    public String deleteCountry(Country country){
        if(countryRepository.existsByCode(country.getCode())){
            countryRepository.delete(country);
            return "deleted";
        }
        else{
            return "country not found";
        }
    }


}
