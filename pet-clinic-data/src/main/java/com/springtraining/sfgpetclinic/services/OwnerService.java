package com.springtraining.sfgpetclinic.services;

import com.springtraining.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
