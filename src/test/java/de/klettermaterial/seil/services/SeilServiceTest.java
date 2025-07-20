package de.klettermaterial.seil.services;

import de.klettermaterial.seil.material.Seil;
import de.klettermaterial.seil.repository.SeilRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SeilServiceTest {

    private SeilRepository seilRepositoryMock;
    private SeilService seilService;

    @BeforeEach
    void vorbereitung() {
        seilRepositoryMock = mock(SeilRepository.class);
        seilService = new SeilService(seilRepositoryMock);
    }

    @Test
    void neuesSeilHinzufuegen() {
        Seil seil = new Seil("TestseilMaryam", LocalDate.of(2020, 1, 1) ,LocalDate.of(2030,1,1),0);
        seilService.neuesSeilHinzufuegen(seil);
        verify(seilRepositoryMock, times(1)).save(seil);
    }

    @Test
    void seilAktualisieren() {
    }

    @Test
    void getAlleSeile() {
    }

    @Test
    void deleteByName() {
    }

    @Test
    void getSeileGefiltert() {
    }
}