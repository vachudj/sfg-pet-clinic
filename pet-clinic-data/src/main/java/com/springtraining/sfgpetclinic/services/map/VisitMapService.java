package com.springtraining.sfgpetclinic.services.map;

import com.springtraining.sfgpetclinic.model.Pet;
import com.springtraining.sfgpetclinic.model.Visit;
import com.springtraining.sfgpetclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll() ;
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        Pet pet = visit.getPet();
        if (pet == null || pet.getOwner() == null || pet.getId() == null || pet.getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
