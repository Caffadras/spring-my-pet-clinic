package com.caffadras.springmypetclinic.controllers;

import com.caffadras.springmypetclinic.model.Owner;
import com.caffadras.springmypetclinic.model.Pet;
import com.caffadras.springmypetclinic.services.PetService;
import com.caffadras.springmypetclinic.services.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class VisitControllerTest {
    @Mock
    PetService petService;
    @Mock
    VisitService visitService;

    @InjectMocks
    VisitController visitController;

    Owner owner;
    Pet pet;

    MockMvc mockMvc;
    @BeforeEach
    void setUp() {
        owner = new Owner();
        owner.setId(1L);
        pet = new Pet();
        pet.setId(1L);
        owner.addPet(pet);

        mockMvc = MockMvcBuilders.standaloneSetup(visitController).build();
    }

    @Test
    void initCreationForm() throws Exception{
        doReturn(pet).when(petService).findById(anyLong());

        mockMvc.perform(get("/owners/1/pets/1/visits/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdateVisitForm"))
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"));
    }

    @Test
    void processCreationForm() throws Exception{
        doReturn(pet).when(petService).findById(anyLong());
        mockMvc.perform(post("/owners/1/pets/1/visits/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/{ownerId}"))
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"));

        verify(visitService, times(1)).save(any());
    }
}