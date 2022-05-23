package com.caffadras.springmypetclinic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "pets")
@Getter
@Setter
public class Pet extends BaseEntity{

    private String name;
    @ManyToOne
    @JoinColumn(name = "pet_type_id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits;

    private LocalDate birthDate;

}
