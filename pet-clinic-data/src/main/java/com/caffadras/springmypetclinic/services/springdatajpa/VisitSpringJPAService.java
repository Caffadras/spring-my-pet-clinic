package com.caffadras.springmypetclinic.services.springdatajpa;

import com.caffadras.springmypetclinic.model.Visit;
import com.caffadras.springmypetclinic.repositories.VisitRepository;
import com.caffadras.springmypetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("spring-data-jpa")
public class VisitSpringJPAService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSpringJPAService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long id) {
        Optional<Visit> optionalVisit = visitRepository.findById(id);
        return optionalVisit.orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
