package com.caffadras.springmypetclinic.repositories;

import com.caffadras.springmypetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
