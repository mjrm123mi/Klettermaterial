package de.klettermaterial.seil.services;

import de.klettermaterial.seil.controller.SeilController;
import de.klettermaterial.seil.material.Seil;
import de.klettermaterial.seil.repository.SeilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class IndexService {

    @Autowired
    private SeilRepository seilRepository;

    @Autowired
    SeilController seilController;

    @GetMapping("/")
    public String index(Model model) {
       // seilController.initdb();
        Iterable<Seil> seile = seilRepository.findAll();
        model.addAttribute("seile", seile); //die Seile aus der Datenbank werden dem model hinzugefuegt
        return "index";
    }
}
