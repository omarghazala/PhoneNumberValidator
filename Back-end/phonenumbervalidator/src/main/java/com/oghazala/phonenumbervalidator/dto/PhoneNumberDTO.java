package com.oghazala.phonenumbervalidator.dto;

import com.oghazala.phonenumbervalidator.entity.PhoneNumber;


public class PhoneNumberDTO {
    private Integer id;
    private String number;
    private String numberState;
    private String numberName;
    private Integer countryId;


    public PhoneNumberDTO() {
    }

    public PhoneNumberDTO(PhoneNumber phoneNumber) {
        this.id=phoneNumber.getId();
        this.number=phoneNumber.getNumber();
        this.numberState=phoneNumber.getNumberState();
        this.numberName=phoneNumber.getNumberName();
        this.countryId=phoneNumber.getCountry().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getNumberName() {
        return numberName;
    }

    public void setNumberName(String numberName) {
        this.numberName = numberName;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }
}
