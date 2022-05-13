package com.caffadras.springmypetclinic.controllers;

import com.caffadras.springmypetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets/index", "/vets", "/vets/index.html", "/vets.html"})
    public String index(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
