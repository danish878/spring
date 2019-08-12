package com.danny.sfgpetclinic.controllers;

import com.danny.sfgpetclinic.fauxspring.BindingResult;
import com.danny.sfgpetclinic.fauxspring.Model;
import com.danny.sfgpetclinic.model.Owner;
import com.danny.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    private static final String OWNERS_CREATE_OR_UPDATE_OWNER_FORM = "owners/createOrUpdateOwnerForm";
    private static final String REDIRECT_OWNERS_1 = "redirect:/owners/1";

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController controller;

    @Mock
    BindingResult bindingResult;

    @Mock
    Model model;

    @Captor
    ArgumentCaptor<String> captor;

    @BeforeEach
    void setUp() {
        // Capture the argument of the findAllByLastNameLike() method
        given(ownerService.findAllByLastNameLike(captor.capture())).willAnswer(invocation -> {
            List<Owner> owners = new ArrayList<>();

            String name = invocation.getArgument(0);

            if (name.equals("%Buck%")) {
                owners.add(new Owner(1L, "Joe", "Buck"));
                return owners;
            } else if (name.equals("%DontFindMe%")) {
                return owners;
            } else if (name.equals("%FindMe%")) {
                owners.add(new Owner(1L, "Joe", "Buck"));
                owners.add(new Owner(2L, "Ajmal", "Khan"));
                return owners;
            }

            throw new RuntimeException("Invalid Argument");
        });
    }

    @Test
    void processFindFormWildcardString() {
        //given
        Owner owner = new Owner(1L, "Joe", "Buck");
//        List<Owner> ownerList = new ArrayList<>();
//        final ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
//        given(ownerService.findAllByLastNameLike(captor.capture())).willReturn(ownerList); // Capture the argument of the findAllByLastNameLike() method

        //when
        String viewName = controller.processFindForm(owner, bindingResult, null);

        //then
        assertThat("%Buck%").isEqualToIgnoringCase(captor.getValue());
        assertThat("redirect:/owners/1").isEqualToIgnoringCase(viewName);
        verifyZeroInteractions(model);
    }

    @Test
    void processFindFormWildcardFound() {
        //given
        Owner owner = new Owner(1L, "Joe", "FindMe");
        InOrder inOrder = inOrder(ownerService, model);

        //when
        String viewName = controller.processFindForm(owner, bindingResult, model);

        //then
        assertThat("%FindMe%").isEqualToIgnoringCase(captor.getValue());
        assertThat("owners/ownersList").isEqualToIgnoringCase(viewName);

        // inOrder asserts
        inOrder.verify(ownerService).findAllByLastNameLike(anyString());
        inOrder.verify(model, times(1)).addAttribute(anyString(), anyList());
        verifyNoMoreInteractions(model);
    }

    @Test
    void processFindFormWildcardNotFound() {
        //given
        Owner owner = new Owner(1L, "Joe", "DontFindMe");

        //when
        String viewName = controller.processFindForm(owner, bindingResult, null);

        verifyNoMoreInteractions(ownerService);

        //then
        assertThat("%DontFindMe%").isEqualToIgnoringCase(captor.getValue());
        assertThat("owners/findOwners").isEqualToIgnoringCase(viewName);
        verifyZeroInteractions(model);
    }

    @Test
    void processCreationFormHasErrors() {
        //given
        Owner owner = new Owner(1L, "Jim", "Bob");
        given(bindingResult.hasErrors()).willReturn(true);

        //when
        String viewName = controller.processCreationForm(owner, bindingResult);

        //then
        assertThat(viewName).isEqualToIgnoringCase(OWNERS_CREATE_OR_UPDATE_OWNER_FORM);
    }

    @Test
    void processCreationFormNoErrors() {
        //given
        Owner owner = new Owner(1L, "Jim", "Bob");
        given(bindingResult.hasErrors()).willReturn(false);
        given(ownerService.save(any())).willReturn(owner);

        //when
        String viewName = controller.processCreationForm(owner, bindingResult);

        //then
        assertThat(viewName).isEqualToIgnoringCase(REDIRECT_OWNERS_1);
    }
}