package com.caffadras.springmypetclinic.controllers;

import com.caffadras.springmypetclinic.model.Owner;
import com.caffadras.springmypetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/owners/find")
    public String getFindForm(Model model){
        model.addAttribute("owner", new Owner());
        return "owners/findOwners";
    }

    @GetMapping("/owners")
    public String processFindForm(Owner owner, Model model){
        if (owner.getLastName() == null){
            owner.setLastName("");
        }

        List<Owner> owners = ownerService.findAllByLastNameLike(owner.getLastName());


        if (owners == null || owners.isEmpty()){
            return "owners/findOwners";
        }
        else if (owners.size() == 1){
            return "redirect:/owners/"+owners.get(0).getId();
        }
        else{
            model.addAttribute("listOwners", owners);
            return "owners/ownersList";
        }
    }

    @GetMapping("/owners/{id}")
    public ModelAndView showById(@PathVariable String id){
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject("owner", ownerService.findById(Long.valueOf(id)));
        return mav;
    }

    @GetMapping("owners/new")
    public String getCreationForm(Model model){
        model.addAttribute("owner", new Owner());
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("owners/new")
    public String processCreationForm(Owner owner){
        ownerService.save(owner);
        return "redirect:/owners/" + owner.getId();
    }

    @GetMapping("/owners/{id}/edit")
    public String getUpdateForm(@PathVariable String id, Model model){
        model.addAttribute("owner", ownerService.findById(Long.valueOf(id)));
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/owners/{id}/edit")
    public String processUpdateForm(@PathVariable String id, Owner owner){
        owner.setId(Long.valueOf(id));
        ownerService.save(owner);
        return "redirect:/owners/{id}";
    }



}

