package com.caffadras.springmypetclinic.initdata;

import com.caffadras.springmypetclinic.model.*;
import com.caffadras.springmypetclinic.services.OwnerService;
import com.caffadras.springmypetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadOwnersAndPets();
        loadVets();
    }
    private void loadOwnersAndPets(){
        PetType catPetType = new PetType();
        catPetType.setName("Cat");

        PetType dogPetType = new PetType();
        dogPetType.setName("Dog");

        Pet pet1 = new Pet();
        pet1.setName("Pet1");
        pet1.setPetType(catPetType);
        pet1.setBirthDate(LocalDate.now());

        Pet pet2 = new Pet();
        pet2.setName("Pet2");
        pet2.setPetType(dogPetType);
        pet2.setBirthDate(LocalDate.now());


        Owner owner1 = new Owner();
        owner1.setFirstName("Jonathan");
        owner1.setLastName("Maestro");
        owner1.getPets().add(pet1);
        pet1.setOwner(owner1);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Daniel");
        owner2.setLastName("Ballocks");
        owner2.getPets().add(pet2);
        pet2.setOwner(owner2);
        ownerService.save(owner2);

    }

    private void loadVets(){
        Speciality surgeonSpeciality = new Speciality();
        surgeonSpeciality.setDescription("Surgeon");

        Speciality janitorSpeciality = new Speciality();
        janitorSpeciality.setDescription("Janitor");

        Vet vet1 = new Vet();
        vet1.setFirstName("Vet");
        vet1.setLastName("Benjamin");
        vet1.getSpecialities().add(surgeonSpeciality);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet");
        vet2.setLastName("Franklin");
        vet2.getSpecialities().add(janitorSpeciality);
        vetService.save(vet2);
    }
}
