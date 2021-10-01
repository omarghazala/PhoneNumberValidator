package com.oghazala.phonenumbervalidator.Service;

import com.oghazala.phonenumbervalidator.dto.CountryDTO;
import com.oghazala.phonenumbervalidator.dto.ListingDTO;
import com.oghazala.phonenumbervalidator.dto.PhoneNumberDTO;
import com.oghazala.phonenumbervalidator.entity.Country;
import com.oghazala.phonenumbervalidator.entity.PhoneNumber;
import com.oghazala.phonenumbervalidator.repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService{
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Autowired
    private CountryService countryService;

    @Transactional
    public List<ListingDTO> readPhoneNumbers(){
        List<ListingDTO> phoneNumbersDTO = new ArrayList<>();
        List<PhoneNumber> phoneNumbers = phoneNumberRepository.findAll();
        phoneNumbers.forEach(phoneNumber -> {
            ListingDTO phoneNumberDTO = new ListingDTO(phoneNumber);
            phoneNumbersDTO.add(phoneNumberDTO);
        });
        return phoneNumbersDTO;
    }

    @Transactional
    public List<ListingDTO> readPhoneNumberByCountryId(Long countryId){
        List<ListingDTO> phoneNumberDTOS = new ArrayList<>();
        List<PhoneNumber> phoneNumbers = phoneNumberRepository.findByCountryId(countryId, Pageable.unpaged());
        phoneNumbers.forEach(phoneNumber -> {
            ListingDTO phoneNumberDTO = new ListingDTO(phoneNumber);
            phoneNumberDTOS.add(phoneNumberDTO);
        });
        return phoneNumberDTOS;
    }

    @Transactional
    public List<ListingDTO> readPhoneNumberByNumberState(String numberState){
        List<ListingDTO> phoneNumberDTOS = new ArrayList<>();
        List<PhoneNumber> phoneNumbers = phoneNumberRepository.findByNumberState(numberState,Pageable.unpaged());
        phoneNumbers.forEach(phoneNumber -> {
            ListingDTO phoneNumberDTO = new ListingDTO(phoneNumber);
            phoneNumberDTOS.add(phoneNumberDTO);
        });
        return phoneNumberDTOS;
    }

    @Transactional
    public String createPhoneNumber(ListingDTO listingDTO){
        String result = null;
        //if(!phoneNumberRepository.existsById(listingDTO.getId())){

        PhoneNumber phoneNumber = new PhoneNumber(listingDTO);
        List<CountryDTO> countryDTOS =  this.countryService.readCountryCode(listingDTO.getCode());

        List<Country> countries = new ArrayList<>();
        countryDTOS.forEach(countryDTO -> {
            Country country = new Country(countryDTO);
            countries.add(country);
        });
        countries.forEach(country -> {
            String wholeNumber =  country.getCode()+" "+phoneNumber.getNumber().toString();
            System.out.println(Pattern.compile(country.getRegex()).matcher(wholeNumber).matches());
            System.out.print(country.getRegex());
            if(Pattern.matches(country.getRegex(),wholeNumber)){
                phoneNumber.setNumberState("valid");
            }
            else{
                phoneNumber.setNumberState("not valid");
            }
            phoneNumber.setCountry(country);
            phoneNumberRepository.save(phoneNumber);
        });

        return "phone number saved";

    }


    @Transactional
    public String updatePhoneNumber(PhoneNumberDTO phoneNumberDTO){
        if(phoneNumberRepository.existsById(phoneNumberDTO.getId())){
            PhoneNumber phoneNumber = new PhoneNumber(phoneNumberDTO);
            phoneNumberRepository.save(phoneNumber);
            return "phone number updated";
        }
        else{
            return "phone number no found";
        }
    }



    @Transactional
    public String deletePhoneNumber(PhoneNumberDTO phoneNumberDTO){
        if(phoneNumberRepository.existsById(phoneNumberDTO.getId())){
            PhoneNumber phoneNumber = new PhoneNumber(phoneNumberDTO);
            phoneNumberRepository.delete(phoneNumber);
            return "deleted";
        }
        else{
            return "phone not found";
        }
    }

}
