package com.caffadras.springmypetclinic.services.springdatajpa;

import com.caffadras.springmypetclinic.model.Vet;
import com.caffadras.springmypetclinic.repositories.VetRepository;
import com.caffadras.springmypetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("spring-data-jpa")
public class VetSpringJPAService implements VetService {

    private final VetRepository vetRepository;

    public VetSpringJPAService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        Optional<Vet> optionalVet =vetRepository.findById(id);
        return optionalVet.orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
