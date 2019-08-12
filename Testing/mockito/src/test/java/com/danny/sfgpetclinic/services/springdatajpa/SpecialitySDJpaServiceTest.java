package com.danny.sfgpetclinic.services.springdatajpa;

import com.danny.sfgpetclinic.model.Speciality;
import com.danny.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    @Mock(lenient = true)
    SpecialtyRepository repository;

    @InjectMocks
    SpecialitySDJpaService service;

    @Test
    void deleteByObject() {
        Speciality speciality = new Speciality();

        service.delete(speciality);

        verify(repository).delete(any(Speciality.class));
    }

    @Test
    void deleteByObjectBDD() {
        //given
        Speciality speciality = new Speciality();

        //when
        service.delete(speciality);

        //then
        then(repository).should().delete(any(Speciality.class));
    }

    @Test
    void findById() {
        Speciality speciality = new Speciality();

        when(repository.findById(1L)).thenReturn(Optional.of(speciality));

        Speciality foundSpeciality = service.findById(1L);

        assertThat(foundSpeciality).isNotNull();

//        verify(repository).findById(1L);
        verify(repository).findById(anyLong());
    }

    @Test
    void findByIdBDD() {
        // given
        Speciality speciality = new Speciality();
        given(repository.findById(1L)).willReturn(Optional.of(speciality));

        // when
        Speciality foundSpeciality = service.findById(1L);

        //then
        assertThat(foundSpeciality).isNotNull();
        then(repository).should(times(1)).findById(anyLong());
        then(repository).shouldHaveNoMoreInteractions();
    }

    @Test
    void deleteById() {
//        service.deleteById(1L);
//        verify(repository).deleteById(1L);

        service.deleteById(1L);
        service.deleteById(1L);
        verify(repository, times(2)).deleteById(1L);
    }

    @Test
    void deleteByIdBDD() {
        //given - none

        //when
        service.deleteById(1L);
        service.deleteById(1L);

        //then
        then(repository).should(times(2)).deleteById(1L);
    }

    @Test
    void deleteByIdAtLeast() {
        service.deleteById(1L);
        service.deleteById(1L);

        verify(repository, atLeastOnce()).deleteById(1L);
    }

    @Test
    void deleteByIdAtLeastBDD() {
        //given - none

        //when
        service.deleteById(1L);
        service.deleteById(1L);

        //then
        then(repository).should(atLeastOnce()).deleteById(1L);
    }

    @Test
    void deleteByIdAtMost() {
        service.deleteById(1L);
        service.deleteById(1L);

        verify(repository, atMost(5)).deleteById(1L);
    }

    @Test
    void deleteByIdAtMostBDD() {
        //given - none

        //when
        service.deleteById(1L);
        service.deleteById(1L);

        //then
        then(repository).should(atMost(5)).deleteById(1L);
    }

    @Test
    void deleteByIdNever() {
        service.deleteById(1L);
        service.deleteById(1L);

        verify(repository, atMost(5)).deleteById(1L);

        verify(repository, never()).deleteById(5L);
    }

    @Test
    void deleteByIdNeverBDD() {
        //given - none

        //when
        service.deleteById(1L);
        service.deleteById(1L);

        //then
        then(repository).should(atMost(5)).deleteById(1L);
        then(repository).should(never()).deleteById(5L);
    }

    @Test
    void testDoThrow() {
        doThrow(new RuntimeException("boom")).when(repository).delete(any());

        assertThrows(RuntimeException.class, () -> repository.delete(new Speciality()));

        verify(repository).delete(any());
    }

    @Test
    void findByIdThrowsBDD() {
        given(repository.findById(1L)).willThrow(new RuntimeException("boom"));

        assertThrows(RuntimeException.class, () -> service.findById(1L));

        then(repository).should().findById(1L);
    }

    @Test
    void deleteBDD() {
        willThrow(new RuntimeException("boom")).given(repository).delete(any());

        assertThrows(RuntimeException.class, () -> repository.delete(new Speciality()));

        then(repository).should().delete(any());
    }

    @Test
    void testSaveLambda() {
        //given
        final String MATCH_ME = "MATCH_ME";
        Speciality speciality = new Speciality();
        speciality.setDescription(MATCH_ME);

        Speciality savedSpeciality = new Speciality();
        savedSpeciality.setId(1L);

        //need mock to only return on match MATCH_ME string
        given(repository.save(argThat(argument -> argument.getDescription().equals(MATCH_ME)))).willReturn(savedSpeciality);

        //when
        Speciality returnedSpeciality = service.save(speciality);

        //then
        assertThat(returnedSpeciality.getId()).isEqualTo(1L);
    }

    @Test
    void testSaveLambdaNotMatch() {
        //given
        final String MATCH_ME = "MATCH_ME";
        Speciality speciality = new Speciality();
        speciality.setDescription("Not a match");

        Speciality savedSpeciality = new Speciality();
        savedSpeciality.setId(1L);

        //need mock to only return on match MATCH_ME string
        given(repository.save(argThat(argument -> argument.getDescription().equals(MATCH_ME)))).willReturn(savedSpeciality);

        //when
        Speciality returnedSpeciality = service.save(speciality);

        //then
        assertNull(returnedSpeciality);
    }
}