package com.danny.sfgpetclinic.services.springdatajpa;

import com.danny.sfgpetclinic.repositories.VetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {

    @Mock
    VetRepository repository;

    @InjectMocks
    VetSDJpaService service;

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(repository).deleteById(1L);
    }
}