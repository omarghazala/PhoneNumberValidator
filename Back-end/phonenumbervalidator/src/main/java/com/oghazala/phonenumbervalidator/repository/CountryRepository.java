package com.oghazala.phonenumbervalidator.repository;

import com.oghazala.phonenumbervalidator.entity.Country;
import com.oghazala.phonenumbervalidator.entity.PhoneNumber;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@CrossOrigin(origins = {"http://localhost:4200","http://localhost:4242"})
public interface CountryRepository extends JpaRepository<Country,Integer> {
    List<Country> findByCode(String code, Pageable page);
    boolean existsByCode(String code);
}
