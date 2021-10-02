package com.oghazala.phonenumbervalidator.Service;

import com.oghazala.phonenumbervalidator.dto.CountryDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CountryService {

    List<CountryDTO> readCountries();
    List<CountryDTO> readCountryCode(String code);
    String createCountry(CountryDTO countryDTO);
    String updateCountry(CountryDTO countryDTO);
    String deleteCountry(Integer id);

}
