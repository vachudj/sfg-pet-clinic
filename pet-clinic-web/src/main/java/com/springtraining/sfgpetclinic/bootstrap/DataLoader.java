package com.springtraining.sfgpetclinic.bootstrap;

import com.springtraining.sfgpetclinic.model.Owner;
import com.springtraining.sfgpetclinic.model.Pet;
import com.springtraining.sfgpetclinic.model.PetType;
import com.springtraining.sfgpetclinic.model.Vet;
import com.springtraining.sfgpetclinic.services.OwnerService;
import com.springtraining.sfgpetclinic.services.PetTypeService;
import com.springtraining.sfgpetclinic.services.VetService;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class DataLoader implements CommandLineRunner {

    private static final Logger logger = getLogger(DataLoader.class);

    private final OwnerService ownerService;

    private final VetService vetService;

    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Glemanne");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("123123123");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedCatPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glemanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("123123123");

        Pet finonasCat = new Pet();
        finonasCat.setName("Just Cat");
        finonasCat.setOwner(owner2);
        finonasCat.setBirthDate(LocalDate.now());
        finonasCat.setPetType(savedCatPetType);
        owner2.getPets().add(finonasCat);

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
