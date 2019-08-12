package com.danny.sfgpetclinic.controllers;

import com.danny.sfgpetclinic.fauxspring.Model;
import com.danny.sfgpetclinic.fauxspring.ModelMapImpl;
import com.danny.sfgpetclinic.model.Vet;
import com.danny.sfgpetclinic.services.SpecialtyService;
import com.danny.sfgpetclinic.services.VetService;
import com.danny.sfgpetclinic.services.map.SpecialityMapService;
import com.danny.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class VetControllerTest {

    VetService vetService;
    SpecialtyService specialtyService;

    VetController vetController;

    @BeforeEach
    @Disabled
    void setUp() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);

        vetController = new VetController(vetService);

        Vet vet1 = new Vet(1L, "joe", "buck", null);
        Vet vet2 = new Vet(2L, "Jimmy", "Smith", null);

        vetService.save(vet1);
        vetService.save(vet2);
    }

    @Test
    @Disabled
    void listVets() {
        Model model = new ModelMapImpl();

        String view = vetController.listVets(model);

        assertThat("vets/index").isEqualTo(view);

        Set modelAttribute = (Set) ((ModelMapImpl) model).getMap().get("vets");

        assertThat(modelAttribute.size()).isEqualTo(2);
    }
}