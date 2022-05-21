package com.caffadras.springmypetclinic.services.springdatajpa;

import com.caffadras.springmypetclinic.model.Speciality;
import com.caffadras.springmypetclinic.repositories.SpecialityRepository;
import com.caffadras.springmypetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("spring-data-jpa")
public class SpecialitySpringJPAService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialitySpringJPAService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long id) {
        Optional<Speciality> specialityOptional = specialityRepository.findById(id);
        return specialityOptional.orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
