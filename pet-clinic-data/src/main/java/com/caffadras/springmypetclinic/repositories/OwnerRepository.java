package com.caffadras.springmypetclinic.repositories;

import com.caffadras.springmypetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Optional<Owner> findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(@Param("lastName") String lastName);
}

