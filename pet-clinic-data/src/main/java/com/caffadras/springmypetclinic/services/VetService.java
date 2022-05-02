package com.caffadras.springmypetclinic.services;

import com.caffadras.springmypetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);

    Vet save(Vet owner);

    Set<Vet> findAll();
}
