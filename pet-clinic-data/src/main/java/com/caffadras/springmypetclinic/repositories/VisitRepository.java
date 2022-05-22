package com.caffadras.springmypetclinic.repositories;

import com.caffadras.springmypetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
