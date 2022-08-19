package com.caffadras.springmypetclinic.services.map;

import com.caffadras.springmypetclinic.model.Speciality;
import com.caffadras.springmypetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map-data")
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {
}
