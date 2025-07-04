package com.example.orm.Country.Model;

//public class Country {
//}

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;


    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
