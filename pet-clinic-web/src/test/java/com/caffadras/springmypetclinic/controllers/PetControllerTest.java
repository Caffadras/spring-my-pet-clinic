package com.caffadras.springmypetclinic.controllers;

import com.caffadras.springmypetclinic.model.Owner;
import com.caffadras.springmypetclinic.model.Pet;
import com.caffadras.springmypetclinic.model.PetType;
import com.caffadras.springmypetclinic.services.OwnerService;
import com.caffadras.springmypetclinic.services.PetService;
import com.caffadras.springmypetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class PetControllerTest {

    @Mock
    PetService petService;
    @Mock
    PetTypeService petTypeService;
    @Mock
    OwnerService ownerService;
    @InjectMocks
    PetController petController;
    MockMvc mockMvc;

    Owner owner;
    Set<PetType> petTypes;

    Pet pet;
    @BeforeEach
    void setUp() {
        owner = new Owner();
        owner.setId(1L);

        pet = new Pet();
        pet.setId(1L);

        PetType catPetType = new PetType();
        catPetType.setName("Cat");
        PetType dogPetType = new PetType();
        dogPetType.setName("Dog");
        petTypes = new HashSet<>();
        petTypes.add(catPetType);
        petTypes.add(dogPetType);

        mockMvc = MockMvcBuilders.standaloneSetup(petController).build();
    }

    @Test
    void initCreationForm() throws Exception{
        doReturn(petTypes).when(petTypeService).findAll();
        doReturn(owner).when(ownerService).findById(anyLong());

        mockMvc.perform(get("/owners/1/pets/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdatePetForm"))
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"));
    }

    @Test
    void processCreationForm() throws Exception {
        doReturn(petTypes).when(petTypeService).findAll();
        doReturn(owner).when(ownerService).findById(anyLong());

        mockMvc.perform(post("/owners/1/pets/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));

        verify(petService, times(1)).save(any());
    }

    @Test
    void initUpdateForm() throws Exception{
        doReturn(petTypes).when(petTypeService).findAll();
        doReturn(owner).when(ownerService).findById(anyLong());
        doReturn(pet).when(petService).findById(anyLong());

        mockMvc.perform(get("/owners/1/pets/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdatePetForm"))
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"));
    }

    @Test
    void processUpdateForm() throws Exception{
        doReturn(petTypes).when(petTypeService).findAll();
        doReturn(owner).when(ownerService).findById(anyLong());

        mockMvc.perform(post("/owners/1/pets/1/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));

        verify(petService, times(1)).save(any());
    }
}