package de.klettermaterial.seil.services;

import de.klettermaterial.seil.controller.SeilController;
import de.klettermaterial.seil.material.Seil;
import de.klettermaterial.seil.repository.SeilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SeilService {


    private final SeilRepository seilRepository;

    public SeilService(SeilRepository seilRepository) {
        this.seilRepository = seilRepository;
    }

    public void addSeil(Seil seil) {
        seilRepository.save(seil);
    }

    public long numberOfSeile() {
        return seilRepository.count();
    }

    public List<Seil> seileVomHersteller(String hersteller) {
        return StreamSupport.stream(seilRepository.findAll().spliterator(), false)
                .filter(seil -> seil.getName().equals(hersteller))
                .collect(Collectors.toList());
    }


    public Iterable<Seil> getAlleSeile() {
        return seilRepository.findAll();
    }
}
