package com.caffadras.springmypetclinic.services.map;

import com.caffadras.springmypetclinic.model.Owner;
import com.caffadras.springmypetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        return map.values()
                .stream()
                .filter(value -> value.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }
}
