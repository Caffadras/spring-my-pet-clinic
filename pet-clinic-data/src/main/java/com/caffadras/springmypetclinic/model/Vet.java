package com.caffadras.springmypetclinic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
@Getter
@Setter
public class Vet extends Person{
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        joinColumns = @JoinColumn(name = "speciality_id"),
        inverseJoinColumns = @JoinColumn(name = "vet_id")
    )
    private Set<Speciality> specialities = new HashSet<>();

}
