package com.caffadras.springmypetclinic.services.map;

import com.caffadras.springmypetclinic.model.PetType;
import com.caffadras.springmypetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map-data")
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

}
