package com.danny.sfgpetclinic.controllers;

import com.danny.sfgpetclinic.model.Pet;
import com.danny.sfgpetclinic.model.Visit;
import com.danny.sfgpetclinic.services.PetService;
import com.danny.sfgpetclinic.services.VisitService;
import com.danny.sfgpetclinic.services.map.PetMapService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class VisitControllerTest {

    @Mock
    VisitService visitService;

//    @Mock
//    PetService petService;

    @Spy //Wrapper around the real implementation
            PetMapService petMapService;

    @InjectMocks
    VisitController visitController;

//    @Test
//    void loadPetWithVisit_MockDemo() {
//        //given
//        Map<String, Object> model = new HashMap<>();
//        Pet pet = new Pet(1L);
//        given(petService.findById(anyLong())).willReturn(pet);
//
//        //when
//        Visit visit = visitController.loadPetWithVisit(1L, model);
//
//        //then
//        assertThat(visit).isNotNull();
//        assertThat(visit.getPet()).isNotNull();
//    }

    @Test
    void loadPetWithVisit_SpyDemo() {
        //given
        Map<String, Object> model = new HashMap<>();

        Pet pet = new Pet(1L);
        Pet pet2 = new Pet(2L);

        petMapService.save(pet);
        petMapService.save(pet2);

        given(petMapService.findById(anyLong())).willCallRealMethod();

        //when
        Visit visit = visitController.loadPetWithVisit(1L, model);

        //then
        assertThat(visit).isNotNull();
        assertThat(visit.getPet()).isNotNull();
        assertThat(visit.getPet().getId()).isEqualTo(1L);
        verify(petMapService, times(1)).findById(anyLong());
    }

    @Test
    void loadPetWithVisitWithStubbing_SpyDemo() {
        //given
        Map<String, Object> model = new HashMap<>();
        Pet pet = new Pet(1L);
        Pet pet2 = new Pet(2L);

        petMapService.save(pet);
        petMapService.save(pet2);

        given(petMapService.findById(anyLong())).willReturn(pet2);

        //when
        Visit visit = visitController.loadPetWithVisit(1L, model);

        //then
        assertThat(visit).isNotNull();
        assertThat(visit.getPet()).isNotNull();
        assertThat(visit.getPet().getId()).isEqualTo(2L);
        verify(petMapService, times(1)).findById(anyLong());
    }
}