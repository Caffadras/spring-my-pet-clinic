package com.caffadras.springmypetclinic.initdata;

import com.caffadras.springmypetclinic.model.Owner;
import com.caffadras.springmypetclinic.model.Speciality;
import com.caffadras.springmypetclinic.model.Vet;
import com.caffadras.springmypetclinic.services.OwnerService;
import com.caffadras.springmypetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        Owner owner1 = new Owner();
        owner1.setFirstName("Jonathan");
        owner1.setLastName("Maestro");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Daniel");
        owner2.setLastName("Ballocks");
        ownerService.save(owner2);


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
