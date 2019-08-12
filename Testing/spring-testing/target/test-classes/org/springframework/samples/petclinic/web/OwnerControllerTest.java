package org.springframework.samples.petclinic.web;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@ExtendWith(MockitoExtension.class)
@SpringJUnitWebConfig(locations = {"classpath:spring/mvc-test-config.xml", "classpath:spring/mvc-core-config.xml"})
class OwnerControllerTest {

    @Autowired
    OwnerController ownerController;

    @Autowired
    ClinicService clinicService;
    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @AfterEach
    void tearDown() {
        reset(clinicService);
    }

    @Test
    void processCreationFormPostValid() throws Exception {
        mockMvc.perform(post("/owners/new")
                .param("firstName", "Jimmy")
                .param("lastName", "Ajmal")
                .param("address", "gali no. 17")
                .param("city", "Ottawa")
                .param("telephone", "1234567890"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void processCreationFormPostNotValid() throws Exception {
        mockMvc.perform(post("/owners/new")
                .param("firstName", "Jimmy")
                .param("lastName", "Ajmal")
                .param("city", "Ottawa"))
                .andExpect(status().isOk())
                .andExpect(model().attributeHasErrors("owner"))
                .andExpect(model().attributeHasFieldErrors("owner", "address"))
                .andExpect(model().attributeHasFieldErrors("owner", "telephone"))
                .andExpect(view().name(OwnerController.VIEWS_OWNER_CREATE_OR_UPDATE_FORM));
    }

    @Test
    void processUpdateOwnerFormPostValid() throws Exception {
        mockMvc.perform(post("/owners/{ownerId}/edit", 7)
                .param("firstName", "Jimmy")
                .param("lastName", "Ajmal")
                .param("address", "gali no. 17")
                .param("city", "Ottawa")
                .param("telephone", "1234567890"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/{ownerId}"));
    }

    @Test
    void processUpdateOwnerFormPostNotValid() throws Exception {
        mockMvc.perform(post("/owners/{ownerId}/edit", 7)
                .param("firstName", "Jimmy")
                .param("lastName", "Ajmal")
                .param("city", "Ottawa"))
                .andExpect(model().attributeHasErrors("owner"))
                .andExpect(model().attributeHasFieldErrors("owner", "address"))
                .andExpect(model().attributeHasFieldErrors("owner", "telephone"))
                .andExpect(status().isOk())
                .andExpect(view().name(OwnerController.VIEWS_OWNER_CREATE_OR_UPDATE_FORM));
    }

    @Test
    void processFindFormReturnListOfOwners() throws Exception {
        //given
        given(clinicService.findOwnerByLastName(""))
                .willReturn(Lists.newArrayList(new Owner(), new Owner())); //adding 2 Owners in ArrayList

        //when
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("selections"))
                .andExpect(view().name("owners/ownersList"));

        //then
        then(clinicService).should().findOwnerByLastName(stringArgumentCaptor.capture());

        assertThat(stringArgumentCaptor.getValue()).isEqualToIgnoringCase("");
    }

    @Test
    void processFindFormOwnerOneResult() throws Exception {
        //given
        final String findJustOne = "findJustOne";

        Owner justOne = new Owner();
        justOne.setId(1);
        justOne.setLastName(findJustOne);

        given(clinicService.findOwnerByLastName(findJustOne))
                .willReturn(Lists.newArrayList(justOne));

        //when
        mockMvc.perform(get("/owners")
                .param("lastName", findJustOne))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));

        //then
        then(clinicService).should().findOwnerByLastName(anyString());

    }

    @Test
    void processFindFormNameNotFoundTest() throws Exception {
        mockMvc.perform(get("/owners")
                .param("lastName", "Don't FIND ME"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"));
    }

    @Test
    void initCreationFormTest() throws Exception {
        mockMvc.perform(get("/owners/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(view().name("owners/createOrUpdateOwnerForm"));
    }
}