package com.oghazala.phonenumbervalidator.repository;

import com.oghazala.phonenumbervalidator.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country,Integer> {
    public boolean existsByCode(String code);
    public List<Country> findByCode(String code);

}
