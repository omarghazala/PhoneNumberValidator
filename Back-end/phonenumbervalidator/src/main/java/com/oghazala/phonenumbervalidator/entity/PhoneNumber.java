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

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;


}
