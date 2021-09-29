package com.oghazala.phonenumbervalidator.dto;

import com.oghazala.phonenumbervalidator.entity.Country;

import javax.persistence.Column;
import javax.persistence.Id;

public class CountryDTO {


    private Long id;
    private String name;
    private String code;
    private String regex;

    public CountryDTO() {
    }

    public CountryDTO(Country country) {
        this.id=country.getId();
        this.name=country.getName();
        this.code=country.getCode();
        this.regex=country.getRegex();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
