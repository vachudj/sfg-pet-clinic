package com.springtraining.sfgpetclinic.repositories;

import com.springtraining.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
