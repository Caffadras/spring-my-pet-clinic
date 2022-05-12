package com.caffadras.springmypetclinic.services.map;

import com.caffadras.springmypetclinic.model.Pet;
import com.caffadras.springmypetclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

}
