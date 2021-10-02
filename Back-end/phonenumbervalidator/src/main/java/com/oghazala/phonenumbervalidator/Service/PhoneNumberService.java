package com.oghazala.phonenumbervalidator.Service;

import com.oghazala.phonenumbervalidator.dto.ListingDTO;
import com.oghazala.phonenumbervalidator.dto.PhoneNumberDTO;
import java.util.List;


public interface PhoneNumberService {

    List<ListingDTO> readPhoneNumbers();
    List<ListingDTO> readPhoneNumberByCountryId(Integer countryId);
    List<ListingDTO> readPhoneNumberByNumberState(String numberState);
    Long readCount();
    String createPhoneNumber(ListingDTO listingDTO);
    String updatePhoneNumber(PhoneNumberDTO phoneNumberDTO);
    String deletePhoneNumber(PhoneNumberDTO phoneNumberDTO);

}








