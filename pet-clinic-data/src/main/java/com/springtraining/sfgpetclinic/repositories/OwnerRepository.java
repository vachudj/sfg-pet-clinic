package com.springtraining.sfgpetclinic.repositories;

import com.springtraining.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
