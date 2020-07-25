package com.company.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "travels")
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String city;
    private String country;
    private String continent;
    private Long yearOfVisit;

    @Override
    public String toString() {
        return "country = " + country + " city = " + city + " continent = " + continent + " year of visit =  " + yearOfVisit;
    }
}
