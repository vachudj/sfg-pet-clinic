package com.springtraining.sfgpetclinic.bootstrap;

import static org.slf4j.LoggerFactory.*;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springtraining.sfgpetclinic.model.Owner;
import com.springtraining.sfgpetclinic.model.Vet;
import com.springtraining.sfgpetclinic.services.OwnerService;
import com.springtraining.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private static final Logger logger = getLogger(DataLoader.class);

    private final OwnerService ownerService;

    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Glemanne");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glemanne");

        ownerService.save(owner2);

        logger.info("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        logger.info("Loaded vets...");
    }
}
