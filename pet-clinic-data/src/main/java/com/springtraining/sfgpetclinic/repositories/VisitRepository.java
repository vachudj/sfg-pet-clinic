package com.springtraining.sfgpetclinic.repositories;

import com.springtraining.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
