package com.caffadras.springmypetclinic.services.map;

import com.caffadras.springmypetclinic.model.Visit;
import com.caffadras.springmypetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map-data")
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Visit save(Visit visit){
        if (visit == null || visit.getPet() == null || visit.getPet().getId() == null ||
            visit.getPet().getOwner() == null || visit.getPet().getOwner().getId() == null){
            throw new RuntimeException("Invalid Visit format!");
        }
        return super.save(visit);
    }

}
