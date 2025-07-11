package de.klettermaterial.seil.controller;

import de.klettermaterial.seil.material.Seil;
import de.klettermaterial.seil.services.IndexService;
import de.klettermaterial.seil.services.SeilService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

/**
 * Controller für die Startseite.
 * Leitet Anfragen an den IndexService weiter.
 */
@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @Autowired
    private SeilController seilController;

    @Autowired
    private SeilService seilService;

    /**
     * Liefert die Startseite
     * @param model Model für das View-Template
     * @return Name des View-Templates ("index")
     */
    @GetMapping("/")
    public String index(Model model) {
        return indexService.index(model);
    }

    /**
     * Der Methode postNewSeil wird ein Seil Objekt übergeben und ein neues Seil wird erstellt.
     * Danach wird die Seite neu geladen.
     * @param newSeil
     * @return "redirect:/"
     */
    @PostMapping("/add")
    public String neuesSeilHinzufugen(@ModelAttribute Seil newSeil) {
        //das Seil kommt aus einem @ModelAttribut und wird zu einem JavaObjekt
        seilService.postNewSeil(newSeil);
        return "redirect:/";
    }

    /**
     * Mit der postDelete Methode kann
     * @param name
     * @return "redirect:/"
     */
    @PostMapping("/delete")
    public String seilLoeschen(@RequestParam("name") String name ) {
        indexService.deleteByName(name);
        return "redirect:/";
    }


    @PostMapping("/update-name")
    public String updateSeilName(@RequestParam String oldName, @RequestParam String newName) {
        indexService.updateName(oldName, newName);
        return "redirect:/";
    }

    @PostMapping("/update-abnutzungspunkte")
    public String updateAbnutzungspunkte(@RequestParam String seilName, @RequestParam int newAbnutzungspunkte) {
        indexService.updateAbnutzungspunkte(seilName, newAbnutzungspunkte);
        return "redirect:/";
    }

    @PostMapping("/update-ablaufdatum")
    public String updateAblaufdatum(String seilName, LocalDate newAblaufdatum) {
       indexService.updateAblaufdatum(seilName, newAblaufdatum);
       return "redirect:/";
    }
}
