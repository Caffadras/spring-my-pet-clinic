package com.caffadras.springmypetclinic.services;

import com.caffadras.springmypetclinic.model.PetType;

import java.util.Optional;


public interface PetTypeService extends CrudService<PetType, Long>{
    Optional<PetType> findByName(String name);

}
