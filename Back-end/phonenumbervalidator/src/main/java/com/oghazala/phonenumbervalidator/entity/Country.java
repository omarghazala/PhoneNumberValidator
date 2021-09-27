package com.oghazala.phonenumbervalidator.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Country")
@Data
public class Country {
    @Id
    @Column(name = "country_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "regex")
    private String regex;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "country")
    private List<PhoneNumber> phoneNumbers;

}
