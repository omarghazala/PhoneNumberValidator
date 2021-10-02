package com.oghazala.phonenumbervalidator.dto;

import com.oghazala.phonenumbervalidator.entity.Country;


public class CountryDTO {


    private Integer id;
    private String name;
    private String code;
    private String regex;

    public CountryDTO() {
    }

    public CountryDTO(Integer id, String name, String code, String regex) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.regex = regex;
    }

    public CountryDTO(Country country) {
        this.id=country.getId();
        this.name=country.getName();
        this.code=country.getCode();
        this.regex=country.getRegex();

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
}
