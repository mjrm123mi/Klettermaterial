package de.klettermaterial.seil.services;

import de.klettermaterial.seil.material.Seil;
import de.klettermaterial.seil.repository.SeilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


/**
 * Die Klasse IndexService enthält die Logik von der Startseite (Index).
 */
@Service
public class IndexService {

    @Autowired
    private SeilRepository seilRepository;

    /**
     * Die Methode index fügt alle Seile dem model mit addAttribute hinzu und ruft die Startseite auf.
     * @param model
     * @return "index" und Spring weiß dann dass die index.html aufgerufen werden soll.
     */
    public String index(Model model) {
       // seilController.initdb();
        Iterable<Seil> seile = seilRepository.findAll();
        model.addAttribute("seile", seile);
        model.addAttribute("neuesSeil", new Seil()); //neu
        return "index"; //Thymeleaf weiß hiermit dass index.html aufgerfuen werden soll
    }
}
