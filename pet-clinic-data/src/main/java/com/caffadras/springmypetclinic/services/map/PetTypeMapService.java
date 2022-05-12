package com.caffadras.springmypetclinic.services.map;

import com.caffadras.springmypetclinic.model.PetType;
import com.caffadras.springmypetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

}
