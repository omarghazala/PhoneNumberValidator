package com.oghazala.phonenumbervalidator.repository;

import com.oghazala.phonenumbervalidator.entity.Country;
import com.oghazala.phonenumbervalidator.entity.PhoneNumber;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@CrossOrigin("http://localhost:4200")
public interface CountryRepository extends JpaRepository<Country,Long> {
    List<Country> findByCode(String code, Pageable page);
}
