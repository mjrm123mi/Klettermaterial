package de.klettermaterial.seil.services;

import de.klettermaterial.seil.material.Seil;
import de.klettermaterial.seil.repository.SeilRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import java.time.LocalDate;
import java.util.List;

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
        List<Seil> seile = seilRepository.findAll();
        model.addAttribute("seile", seile);
        model.addAttribute("newSeil", new Seil()); //ein leeres Seil wird erstellt, das brauch ich später für create
        return "index"; //Thymeleaf weiß hiermit dass index.html aufgerfuen werden soll
    }

    @Transactional
    public void deleteByName(String name) {
        seilRepository.deleteByName(name);
    }

    @Transactional
    public void updateName(String oldName, String newName) {
        Seil seil = seilRepository.findByName(oldName);
        seil.setName(newName);
        seilRepository.save(seil);
    }

    @Transactional
    public void updateAbnutzungspunkte(String seilName, int newAbnutzungspunkte) {
        Seil seil = seilRepository.findByName(seilName);
        seil.setAbnutzungspunkte(newAbnutzungspunkte);
        seilRepository.save(seil);
    }

    @Transactional
    public void updateAblaufdatum(String seilName, LocalDate newAblaufdatum) {
        Seil seil = seilRepository.findByName(seilName);
        seil.setAblaufdatum(newAblaufdatum);
        seilRepository.save(seil);
    }

    public String getNameById(long id) {
        Seil seil = seilRepository.findById(id).orElseThrow(() -> new RuntimeException("Seil nicht gefunden"));
        return seil.getName();
    }

}
