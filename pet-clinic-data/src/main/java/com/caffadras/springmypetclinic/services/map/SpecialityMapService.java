package com.caffadras.springmypetclinic.services.map;

import com.caffadras.springmypetclinic.model.Speciality;
import com.caffadras.springmypetclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {
}
