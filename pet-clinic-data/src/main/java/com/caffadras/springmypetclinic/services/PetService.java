package com.caffadras.springmypetclinic.services;

import com.caffadras.springmypetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Pet save(Pet owner);

    Set<Pet> findAll();
}
