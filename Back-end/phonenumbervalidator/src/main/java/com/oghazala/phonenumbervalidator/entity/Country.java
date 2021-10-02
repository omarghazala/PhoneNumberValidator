package com.oghazala.phonenumbervalidator.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.oghazala.phonenumbervalidator.dto.CountryDTO;
import com.oghazala.phonenumbervalidator.dto.ListingDTO;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Country")
public class Country {

    @Id
    @Column(name = "country_id")
    private Integer id;

    @Column(name = "name")
    private String name;


    @Column(name = "code")
    private String code;

    @Column(name = "regex")
    private String regex;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "country")
    @JsonManagedReference
    private List<PhoneNumber> phoneNumbers;

    public Country() {
    }

    public Country(Integer id, String code, String name, String regex) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.regex = regex;
    }

    public Country(CountryDTO countryDTO) {
        this.id = countryDTO.getId();
        this.name = countryDTO.getName();
        this.code = countryDTO.getCode();
        this.regex = countryDTO.getRegex();


    }

    public Country(ListingDTO listingDTO){
        this.code = listingDTO.getCode();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
