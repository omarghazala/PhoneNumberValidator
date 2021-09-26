package com.oghazala.phonenumbervalidator.Service;

import com.oghazala.phonenumbervalidator.entity.Country;
import com.oghazala.phonenumbervalidator.entity.PhoneNumber;
import com.oghazala.phonenumbervalidator.repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PhoneNumberService {
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Transactional
    public String createPhoneNumber(PhoneNumber phoneNumber){
        if(!phoneNumberRepository.existsById(phoneNumber.getId())){
            phoneNumberRepository.save(phoneNumber);
            return "phone number saved";
        }
        else{
            return "phone number already exists";
        }
    }

    public List<PhoneNumber> readPhoneNumbers(){
        return phoneNumberRepository.findAll();
    }

    @Transactional
    public String updateCountry(PhoneNumber phoneNumber){
        if(phoneNumberRepository.existsById(phoneNumber.getId())){
            List<PhoneNumber> phoneNumbers = phoneNumberRepository.findById(phoneNumber.getNumber());
            phoneNumbers.forEach(phoneNumberToBeUpdated->{
                phoneNumberToBeUpdated.setId(phoneNumber.getId());
                phoneNumberToBeUpdated.setNumber(phoneNumber.getNumber());

            });

            return "phone number updated";
        }
        else{
            return "phone number no found";
        }
    }

    @Transactional
    public String deleteCountry(PhoneNumber phoneNumber){
        if(phoneNumberRepository.existsById(phoneNumber.getId())){
            phoneNumberRepository.delete(phoneNumber);
            return "deleted";
        }
        else{
            return "phone not found";
        }
    }



}
