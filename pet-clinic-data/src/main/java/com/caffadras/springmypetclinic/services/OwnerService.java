package com.caffadras.springmypetclinic.services;

import com.caffadras.springmypetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);

}
