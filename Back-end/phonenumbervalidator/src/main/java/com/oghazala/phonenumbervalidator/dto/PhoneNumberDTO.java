package com.oghazala.phonenumbervalidator.dto;

import com.oghazala.phonenumbervalidator.entity.PhoneNumber;


public class PhoneNumberDTO {
    private Long id;
    private String number;
    private String numberState;
    private Long countryId;

    public PhoneNumberDTO() {
    }

    public PhoneNumberDTO(PhoneNumber phoneNumber) {
        this.id=phoneNumber.getId();
        this.number=phoneNumber.getNumber();
        this.numberState=phoneNumber.getNumberState();
        this.countryId=phoneNumber.getCountry().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumberState() {
        return numberState;
    }

    public void setNumberState(String numberState) {
        this.numberState = numberState;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}
