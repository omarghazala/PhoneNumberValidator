package com.oghazala.phonenumbervalidator.Service;

import com.oghazala.phonenumbervalidator.dto.ListingDTO;
import com.oghazala.phonenumbervalidator.dto.PhoneNumberDTO;
import com.oghazala.phonenumbervalidator.entity.PhoneNumber;
import com.oghazala.phonenumbervalidator.repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PhoneNumberService {
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

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
        List<PhoneNumber> phoneNumbers = phoneNumberRepository.findByCountryId(countryId,Pageable.unpaged());
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
    public String createPhoneNumber(PhoneNumberDTO phoneNumberDto){
        if(!phoneNumberRepository.existsById(phoneNumberDto.getId())){
            PhoneNumber phoneNumber = new PhoneNumber(phoneNumberDto);
            phoneNumberRepository.save(phoneNumber);
            return "phone number saved";
        }
        else{
            return "phone number already exists";
        }
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


//    @Transactional
//    public List<PhoneNumber> readPhoneNumberById(List<Long> id){
//        return phoneNumberRepository.findAllById(id);
//    }
//
//    @Transactional
//    public List<PhoneNumberDTO> readPhoneNumbersByIdAndCountry(){
//        List<PhoneNumberDTO> phoneNumbersDTO = new ArrayList<>();
//        List<PhoneNumber> phoneNumbers = phoneNumberRepository.readPhoneNumberByIdAndCountry(Pageable.unpaged());
//        phoneNumbers.forEach(phoneNumber -> {
//            PhoneNumberDTO phoneNumberDTO = new PhoneNumberDTO(phoneNumber);
//            phoneNumbersDTO.add(phoneNumberDTO);
//        });
//        return phoneNumbersDTO;
//    }








}
