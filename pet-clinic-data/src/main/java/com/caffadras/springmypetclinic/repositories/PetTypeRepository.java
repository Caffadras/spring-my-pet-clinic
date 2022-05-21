package com.caffadras.springmypetclinic.repositories;

import com.caffadras.springmypetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
