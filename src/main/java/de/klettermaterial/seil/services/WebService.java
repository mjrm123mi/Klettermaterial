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



}
