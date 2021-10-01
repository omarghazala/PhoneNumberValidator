package com.oghazala.phonenumbervalidator.Service;

import com.oghazala.phonenumbervalidator.dto.CountryDTO;
import com.oghazala.phonenumbervalidator.entity.Country;
import com.oghazala.phonenumbervalidator.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public interface CountryService {

    List<CountryDTO> readCountries();
    List<CountryDTO> readCountryCode(String code);
    String createCountry(CountryDTO countryDTO);
    String updateCountry(CountryDTO countryDTO);
    String deleteCountry(Integer id);

}
