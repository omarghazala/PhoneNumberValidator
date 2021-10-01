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

import javax.print.DocFlavor;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;


public interface PhoneNumberService {

    List<ListingDTO> readPhoneNumbers();
    List<ListingDTO> readPhoneNumberByCountryId(Long countryId);
    List<ListingDTO> readPhoneNumberByNumberState(String numberState);
    String createPhoneNumber(ListingDTO listingDTO);
    String updatePhoneNumber(PhoneNumberDTO phoneNumberDTO);
    String deletePhoneNumber(PhoneNumberDTO phoneNumberDTO);

}








