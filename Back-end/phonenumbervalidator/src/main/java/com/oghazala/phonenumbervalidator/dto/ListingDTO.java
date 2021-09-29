package com.oghazala.phonenumbervalidator.dto;

import com.oghazala.phonenumbervalidator.entity.PhoneNumber;

import javax.persistence.Column;

public class ListingDTO extends PhoneNumberDTO{

    private String name;

    private String code;

    public ListingDTO() {
    }

    public ListingDTO(PhoneNumber phoneNumber) {
        super(phoneNumber);
        this.name = phoneNumber.getCountry().getName();
        this.code = phoneNumber.getCountry().getCode();
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
}
