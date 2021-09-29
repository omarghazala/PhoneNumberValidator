package com.oghazala.phonenumbervalidator.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.oghazala.phonenumbervalidator.dto.CountryDTO;
import com.oghazala.phonenumbervalidator.dto.PhoneNumberDTO;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
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
    @JsonManagedReference
    private List<PhoneNumber> phoneNumbers;

    public Country() {
    }

    public Country(CountryDTO countryDTO) {
        this.id = countryDTO.getId();
        this.name = countryDTO.getName();
        this.code = countryDTO.getCode();
        this.regex = countryDTO.getRegex();


    }
}
