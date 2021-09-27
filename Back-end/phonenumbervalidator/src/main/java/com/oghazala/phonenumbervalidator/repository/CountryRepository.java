package com.oghazala.phonenumbervalidator.repository;

import com.oghazala.phonenumbervalidator.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "country",path="country")
@CrossOrigin("http://localhost:4200")
public interface CountryRepository extends JpaRepository<Country,Long> {
//    public boolean existsByCode(String code);
//    public List<Country> findByCode(String code);

}
