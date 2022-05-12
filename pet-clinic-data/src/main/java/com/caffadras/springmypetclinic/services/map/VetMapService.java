package com.caffadras.springmypetclinic.services.map;


import com.caffadras.springmypetclinic.model.Vet;
import com.caffadras.springmypetclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

}
