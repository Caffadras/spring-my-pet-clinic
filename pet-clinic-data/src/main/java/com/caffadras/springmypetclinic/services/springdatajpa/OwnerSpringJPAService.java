package com.caffadras.springmypetclinic.services.springdatajpa;

import com.caffadras.springmypetclinic.model.Owner;
import com.caffadras.springmypetclinic.repositories.OwnerRepository;
import com.caffadras.springmypetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("spring-data-jpa")
public class OwnerSpringJPAService implements OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerSpringJPAService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);
        return optionalOwner.orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        Optional<Owner> optionalOwner = ownerRepository.findByLastName(lastName);
        return optionalOwner.orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike("%" + lastName + "%");
    }
}
