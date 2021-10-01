package com.oghazala.phonenumbervalidator.Service;

import com.oghazala.phonenumbervalidator.dto.CountryDTO;
import com.oghazala.phonenumbervalidator.entity.Country;
import com.oghazala.phonenumbervalidator.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<CountryDTO> readCountries(){
        List<CountryDTO> countryDTOS = new ArrayList<>();
        List<Country> countries = countryRepository.findAll();
        countries.forEach(country -> {
            CountryDTO countryDTO = new CountryDTO(country);
            countryDTOS.add(countryDTO);
        });
        return countryDTOS;
    }

    @Transactional
    public List<CountryDTO> readCountryCode(String code){
        List<CountryDTO> countryDTOS = new ArrayList<>();
        List<Country> countries = countryRepository.findByCode(code, Pageable.unpaged());
        countries.forEach(country -> {
            CountryDTO countryDTO = new CountryDTO(country);
            countryDTOS.add(countryDTO);
        });
        return countryDTOS;
    }

    @Transactional
    public String createCountry(CountryDTO countryDTO){
        if(!countryRepository.existsById(countryDTO.getId())){
            Country country = new Country(countryDTO);
            countryRepository.save(country);
            return "country saved";
        }
        else{
            return "country already exists";
        }
    }



    @Transactional
    public String updateCountry(CountryDTO countryDTO){
        if(countryRepository.existsByCode(countryDTO.getCode())){
            Country country = new Country(countryDTO);
            countryRepository.save(country);
            return "country updated";
        }
        else{
            return "country no found";
        }



    }

    @Transactional
    public String deleteCountry(Integer id){
        if(countryRepository.existsById(id)){
            countryRepository.deleteById(id);
            return "deleted";
        }
        else{
            return "country not found";
        }
    }
}
