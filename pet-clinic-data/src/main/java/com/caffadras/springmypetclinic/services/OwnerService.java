package com.caffadras.springmypetclinic.services;

import com.caffadras.springmypetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
