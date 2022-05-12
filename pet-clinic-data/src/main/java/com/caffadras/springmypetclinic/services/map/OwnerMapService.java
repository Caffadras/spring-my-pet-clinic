package com.caffadras.springmypetclinic.services.map;

import com.caffadras.springmypetclinic.model.Owner;
import com.caffadras.springmypetclinic.services.OwnerService;
import com.caffadras.springmypetclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;

    public OwnerMapService(PetService petService) {
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return map.values()
                .stream()
                .filter(value -> value.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Owner save(Owner object){
        if (object == null) return null;

        if(!object.getPets().isEmpty()){
            object.getPets().forEach(pet -> {
                if (pet.getId() == null){
                    petService.save(pet);
                }
            });
        }

        return super.save(object);
    }

}
