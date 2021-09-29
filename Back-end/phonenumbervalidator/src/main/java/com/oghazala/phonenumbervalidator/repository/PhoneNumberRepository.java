package com.oghazala.phonenumbervalidator.repository;

import com.oghazala.phonenumbervalidator.dto.PhoneNumberDTO;
import com.oghazala.phonenumbervalidator.entity.PhoneNumber;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@CrossOrigin("http://localhost:4200")
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber,Long> {
    List<PhoneNumber> findByCountryId(Long id, Pageable page);
    List<PhoneNumber> findByNumberState(String state, Pageable page);

//    @Query(value = "SELECT pn from PhoneNumber pn join pn.country")
//    List<PhoneNumber> readPhoneNumberByCountryId(Pageable pageable);
}
