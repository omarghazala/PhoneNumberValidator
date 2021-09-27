package com.oghazala.phonenumbervalidator.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Phone_Number")
@Data
public class PhoneNumber {
    @Id
    @Column(name = "number_id")
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "number_state")
    private String number_state;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

}
