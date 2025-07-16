package de.klettermaterial.seil.services;

import de.klettermaterial.seil.material.Seil;
import de.klettermaterial.seil.repository.SeilRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Die Klasse IndexService enthält die Logik von der Startseite (Index).
 */
@Service
public class WebService {

    @Autowired
    private SeilRepository seilRepository;

    public List<Seil> getAlleSeile() {
        return seilRepository.findAllByOrderByAblaufdatum();
    }

    @Transactional
    public void deleteByName(String name) {
        seilRepository.deleteByName(name);
    }

    public String getNameById(long id) {
        Seil seil = seilRepository.findById(id).orElseThrow(() -> new RuntimeException("Seil nicht gefunden"));
        return seil.getName();
    }

    public Seil getSeilById(long id) {
        Seil seil = seilRepository.findById(id).orElseThrow(() -> new RuntimeException("Seil nicht gefunden"));
        return seil;
    }

}
