package com.caffadras.springmypetclinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "specialities")
@Getter
@Setter
public class Speciality extends BaseEntity{
    private String description;
}
