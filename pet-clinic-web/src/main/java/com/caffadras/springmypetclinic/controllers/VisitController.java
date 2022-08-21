package com.caffadras.springmypetclinic.controllers;

import com.caffadras.springmypetclinic.model.Pet;
import com.caffadras.springmypetclinic.model.Visit;
import com.caffadras.springmypetclinic.services.PetService;
import com.caffadras.springmypetclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VisitController {
    private final VisitService visitService;
    private final PetService petService;

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable Long petId, Model model){
        Pet pet = petService.findById(petId);
        model.addAttribute("pet", pet);
        model.addAttribute("owner", pet.getOwner());
        Visit visit = new Visit();
        pet.addVisit(visit);
        return visit;
    }

    @GetMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String initCreationForm(){
        return "pets/createOrUpdateVisitForm";
    }

    @PostMapping("owners/{ownerId}/pets/{petId}/visits/new")
    public String processCreationForm(Visit visit){
        visitService.save(visit);
        return "redirect:/owners/{ownerId}";
    }

}
