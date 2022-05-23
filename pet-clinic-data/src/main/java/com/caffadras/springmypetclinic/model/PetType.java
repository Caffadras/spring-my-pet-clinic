package com.caffadras.springmypetclinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pet_types")
@Getter
@Setter
public class PetType extends BaseEntity{
    private String name;
}
