package com.oghazala.phonenumbervalidator.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.oghazala.phonenumbervalidator.dto.ListingDTO;
import com.oghazala.phonenumbervalidator.dto.PhoneNumberDTO;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "phone_number")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "number_id")
    private Integer id;


    @Column(name = "number")
    private String number;

    @Column(name = "number_state")
    private String numberState;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonBackReference
    private Country country;

    public PhoneNumber() {
    }

    public PhoneNumber(PhoneNumberDTO phoneNumberDto) {
        this.id = phoneNumberDto.getId();
        this.number = phoneNumberDto.getNumber();
        this.numberState = phoneNumberDto.getNumberState();
        this.country = new Country();
        this.country.setId(phoneNumberDto.getCountryId());
    }

    public PhoneNumber(ListingDTO listingDTO){
        this.id = listingDTO.getId();
        this.number = listingDTO.getNumber();

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
