package com.springtraining.sfgpetclinic.repositories;

import com.springtraining.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
