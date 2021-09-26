package com.oghazala.phonenumbervalidator.repository;

import com.oghazala.phonenumbervalidator.entity.Country;
import com.oghazala.phonenumbervalidator.entity.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber,Long> {
    public boolean existsById(String code);
    public List<PhoneNumber> findById(String code);
}
