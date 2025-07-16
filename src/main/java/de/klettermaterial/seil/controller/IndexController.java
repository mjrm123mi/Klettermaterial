package de.klettermaterial.seil.controller;

import de.klettermaterial.seil.material.Seil;
import de.klettermaterial.seil.services.IndexService;
import de.klettermaterial.seil.services.SeilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller für die Startseite.
 * Leitet Anfragen an den IndexService weiter.
 */
@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @Autowired
    private SeilService seilService;

    /**
     * Liefert die Startseite
     * @param model Model für das View-Template
     * @return Name des View-Templates ("index")
     */
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("seile", indexService.getAlleSeile());
        model.addAttribute("newSeil", new Seil());
        return "index";
    }

    /**
     * Der Methode postNewSeil wird ein Seil Objekt übergeben und ein neues Seil wird erstellt.
     * Danach wird die Seite neu geladen.
     * @param newSeil
     * @return "redirect:/"
     */
    @PostMapping("/add")
    public String neuesSeilHinzufugen(@ModelAttribute Seil newSeil) {
        seilService.neuesSeilHinzufuegen(newSeil);
        return "redirect:/";
    }

    /**
     * Mit der seilLoeschen Methode kann ein Seil gelöscht werden.
     * @param name
     * @return "redirect:/"
     */
    @PostMapping("/delete")
    public String seilLoeschen(@RequestParam("name") String name ) {
        indexService.deleteByName(name);
        return "redirect:/";
    }

    @GetMapping("/loeschen")
    public String loeschen(@RequestParam("id") long id, Model model) {
        String name = indexService.getNameById(id);
        model.addAttribute("loeschenName", name);
        return "loeschen";
    }

    @GetMapping("/bearbeiten")
    public String bearbeitenName(@RequestParam("id") long id, Model model) {
      Seil seil = indexService.getSeilById(id);
      model.addAttribute("seilBearbeiten", seil);
      return "bearbeiten";
    }

    @PostMapping("/update")
    public String seilBearbeiten(@ModelAttribute Seil seil) {
        seilService.seilAktualisieren(seil);
        return "redirect:/";
    }

    /**
     * SeilService wird aufgerufen und Datenbank initalisiert.
     */
    @GetMapping("/initdb")
    public String initdb(){
        return seilService.initdb();
    }
}
