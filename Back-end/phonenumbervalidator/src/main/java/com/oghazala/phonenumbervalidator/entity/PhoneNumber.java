package com.oghazala.phonenumbervalidator.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.oghazala.phonenumbervalidator.dto.PhoneNumberDTO;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "phone_number")
@Data
public class PhoneNumber {
    @Id
    @Column(name = "number_id")
    private Long id;

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
}
