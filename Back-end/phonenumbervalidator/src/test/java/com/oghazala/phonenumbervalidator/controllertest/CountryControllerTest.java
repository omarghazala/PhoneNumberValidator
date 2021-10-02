package com.oghazala.phonenumbervalidator.controllertest;


import com.oghazala.phonenumbervalidator.Service.CountryService;
import com.oghazala.phonenumbervalidator.dto.CountryDTO;
import com.oghazala.phonenumbervalidator.entity.Country;
import com.oghazala.phonenumbervalidator.repository.CountryRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryControllerTest {

    @Autowired
    private CountryService countryService;

    @MockBean
    private CountryRepository countryRepository;

    @Test
    public void readCountriesTest(){
        Country country = new Country(10,"(237)","Cameroon","\\(237\\)\\ ?[2368]\\d{7,8}$");
        Country country1 = new Country(20,"(251)","Ethiopia","\\(251\\)\\ ?[1-59]\\d{8}$");
        Country country2 = new Country(30,"(212)","Morocco","\\(212\\)\\ ?[5-9]\\d{8}$");
        Country country3 = new Country(40,"(258)","Mozambique","\\(258\\)\\ ?[28]\\d{7,8}$");
        Country country4 = new Country(50,"(256)","Uganda","\\(256\\)\\ ?\\d{9}$");
        List<Country> countryList = new ArrayList<>();
        countryList.add(country);
        countryList.add(country1);
        countryList.add(country2);
        countryList.add(country3);
        countryList.add(country4);

        when(countryRepository.findAll()).thenReturn(countryList);

        assertEquals(5,countryRepository.findAll().size());

    }

    @Test
    public void createCountryTest(){
        Country country = new Country(10,"(237)","Cameroon","\\(237\\)\\ ?[2368]\\d{7,8}$");
        when(countryRepository.save(country)).thenReturn(country);

        assertEquals("country saved",countryService.createCountry(new CountryDTO(country)));
    }




}
