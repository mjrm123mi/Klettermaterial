package de.klettermaterial.seil.controller;

import de.klettermaterial.seil.repository.SeilRepository;
import de.klettermaterial.seil.material.Seil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private SeilRepository seilRepository;
    @Autowired
    private SeilController seilController;

    @GetMapping("/")
    public String index(Model model) {
        seilController.initdb();
        Iterable<Seil> seile = seilRepository.findAll();
        model.addAttribute("seile", seile); //die Seile aus der Datenbank werden dem model hinzugefuegt
        return "index";
    }
}
