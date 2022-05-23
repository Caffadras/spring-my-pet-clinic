package com.caffadras.springmypetclinic.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class Person extends BaseEntity {
    private String firstName;

    private String lastName;
}
