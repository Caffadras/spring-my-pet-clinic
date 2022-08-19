package com.caffadras.springmypetclinic.initdata;

import com.caffadras.springmypetclinic.model.*;
import com.caffadras.springmypetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final VisitService visitService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, VisitService visitService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.visitService = visitService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
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

        petTypeService.save(catPetType);
        petTypeService.save(dogPetType);

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
        owner1.setAddress("address1");
        owner1.setCity("city1");
        owner1.setTelephone("phone1");
        owner1.getPets().add(pet1);
        pet1.setOwner(owner1);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Daniel");
        owner2.setLastName("Ballocks");
        owner2.setAddress("address2");
        owner2.setCity("city2");
        owner2.setTelephone("phone2");
        owner2.getPets().add(pet2);
        pet2.setOwner(owner2);
        ownerService.save(owner2);


        Visit firstVisit = new Visit();
        firstVisit.setDate(LocalDate.now());
        firstVisit.setDescription("Our first visit");
        firstVisit.setPet(pet1);
        visitService.save(firstVisit);

    }

    private void loadVets(){
        Speciality surgeonSpeciality = new Speciality();
        surgeonSpeciality.setDescription("Surgeon");

        Speciality janitorSpeciality = new Speciality();
        janitorSpeciality.setDescription("Janitor");

        specialityService.save(surgeonSpeciality);
        specialityService.save(janitorSpeciality);

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
