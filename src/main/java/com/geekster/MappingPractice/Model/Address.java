package com.geekster.MappingPractice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String landmark;
    private String zipcode;
    private String district;
    private String state;
    private String country;
}
