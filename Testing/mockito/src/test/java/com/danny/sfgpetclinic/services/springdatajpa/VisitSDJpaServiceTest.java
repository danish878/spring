package com.danny.sfgpetclinic.services.springdatajpa;

import com.danny.sfgpetclinic.model.Visit;
import com.danny.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository repository;

    @InjectMocks
    VisitSDJpaService service;

    @Test
    void findAll() {
        Set<Visit> visits = new HashSet<>();
        visits.add(new Visit());

        when(repository.findAll()).thenReturn(visits);

        Set<Visit> foundVisits = service.findAll();

        verify(repository).findAll();

        assertThat(foundVisits).hasSize(1);
    }

    @Test
    void findAllBDD() {
        //given
        Set<Visit> visits = new HashSet<>();
        visits.add(new Visit());
        given(repository.findAll()).willReturn(visits);

        //when
        Set<Visit> foundVisits = service.findAll();

        //then
        then(repository).should().findAll();
        assertThat(foundVisits).hasSize(1);
    }

    @Test
    void findById() {
        Visit visit = new Visit();

        when(repository.findById(anyLong())).thenReturn(Optional.of(visit));

        Visit foundVisit = service.findById(1L);

        verify(repository).findById(anyLong());

        assertThat(foundVisit).isNotNull();
    }

    @Test
    void save() {
        Visit visit = new Visit();

        when(repository.save(any(Visit.class))).thenReturn(visit);

        Visit savedVisit = service.save(new Visit());

        verify(repository).save(any(Visit.class));

        assertThat(savedVisit).isNotNull();
    }

    @Test
    void delete() {
        service.delete(new Visit());

        verify(repository).delete(any(Visit.class));
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(repository).deleteById(anyLong());
    }
}