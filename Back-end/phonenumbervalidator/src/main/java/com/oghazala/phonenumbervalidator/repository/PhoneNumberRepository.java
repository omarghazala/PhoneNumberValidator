package com.oghazala.phonenumbervalidator.repository;

import com.oghazala.phonenumbervalidator.entity.PhoneNumber;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

//@RepositoryRestResource(collectionResourceRel = "phoneNumber",path = "phone-number")
@CrossOrigin("http://localhost:4200")
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber,Long> {
    Page<PhoneNumber> findByCountryId(@RequestParam("id") Long id, Pageable page);
}
