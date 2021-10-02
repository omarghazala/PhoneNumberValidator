package com.oghazala.phonenumbervalidator.controllertest;

import com.oghazala.phonenumbervalidator.Service.CountryService;
import com.oghazala.phonenumbervalidator.Service.PhoneNumberService;
import com.oghazala.phonenumbervalidator.dto.CountryDTO;
import com.oghazala.phonenumbervalidator.dto.ListingDTO;
import com.oghazala.phonenumbervalidator.dto.PhoneNumberDTO;
import com.oghazala.phonenumbervalidator.entity.Country;
import com.oghazala.phonenumbervalidator.entity.PhoneNumber;
import com.oghazala.phonenumbervalidator.repository.CountryRepository;
import com.oghazala.phonenumbervalidator.repository.PhoneNumberRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneNumberControllerTest {

    @Autowired
    private PhoneNumberService phoneNumberService;

    @MockBean
    private PhoneNumberRepository phoneNumberRepository;




    @Test
    public void createPhoneNumberTest(){
        PhoneNumber phoneNumber =  new PhoneNumber(11,"22222222","not valid","ziad tarek");
        phoneNumber.setCountry( new Country(10,"(237)","Cameroon","\\(237\\)\\ ?[2368]\\d{7,8}$"));

        when(phoneNumberRepository.save(phoneNumber)).thenReturn(phoneNumber);

        assertEquals("phone number saved",phoneNumberService.createPhoneNumber(new ListingDTO(phoneNumber)));
    }

}
