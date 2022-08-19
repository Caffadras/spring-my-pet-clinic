package com.caffadras.springmypetclinic.services.map;


import com.caffadras.springmypetclinic.model.Vet;
import com.caffadras.springmypetclinic.services.SpecialityService;
import com.caffadras.springmypetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map-data")
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet object){
        if (object == null) return null;
        if (!object.getSpecialities().isEmpty()){
            object.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null){
                    specialityService.save(speciality);
                }
            });
        }
        return super.save(object);
    }
}
