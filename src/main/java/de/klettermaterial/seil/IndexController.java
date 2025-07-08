package de.klettermaterial.seil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {
    @Autowired
    private SeilRepository seilRepository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Seil> seile = seilRepository.findAll(); //Ergebnis von findAll() wird in Seile gespeichert
        model.addAttribute("seile", seile); //die Seile aus der Datenbank werden dem model hinzugefuegt
        return "index"; //damit wird Thymeleaf gesagt dass die HTML Datei angezeigt werden soll
    }
}
