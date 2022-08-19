package com.caffadras.springmypetclinic.controllers;

import com.caffadras.springmypetclinic.model.Owner;
import com.caffadras.springmypetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController ownerController;


    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void showById() throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);

        doReturn(owner1).when(ownerService).findById(eq(1L));

        mockMvc.perform(get("/owners/1"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("owner", hasProperty("id", is(1L))));
    }


    @Test
    void processFindForm() throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        Owner owner2 = new Owner();
        owner2.setId(2L);

        doReturn(new ArrayList<Owner>()).when(ownerService).findAllByLastNameLike(eq("no match"));
        doReturn(List.of(owner1)).when(ownerService).findAllByLastNameLike(eq("one match"));
        doReturn(List.of(owner1, owner2)).when(ownerService).findAllByLastNameLike(eq("more than one match"));


        mockMvc.perform(get("/owners?lastName=no match"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"));

        mockMvc.perform(get("/owners?lastName=one match"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"))
                .andExpect(model().attributeExists("owner"));

        mockMvc.perform(get("/owners?lastName=more than one match"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attribute("listOwners", hasSize(2)));
    }

    @Test
    void getFindForm() throws Exception {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"))
                .andExpect(model().attributeExists("owner"));
    }
}