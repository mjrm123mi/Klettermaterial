package de.klettermaterial.seil.controller;

import de.klettermaterial.seil.material.Seil;
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
public class SeilController {

    @Autowired
    private SeilService seilService;

    /**
     * Liefert die Startseite
     * @param model Model für das View-Template
     * @return Name des View-Templates ("index")
     */
    @GetMapping("/")
    public String index(@RequestParam(value = "nameFilter", required = false) String nameFilter,
                        @RequestParam(value = "herstellungsJahrFilter", required = false) Integer herstellungsJahrFilter,
                        Model model) {

        model.addAttribute("seile", seilService.getSeileGefiltert(nameFilter, herstellungsJahrFilter));
        model.addAttribute("newSeil", new Seil());
        model.addAttribute("filter", nameFilter);
        model.addAttribute("herstellungsJahrFilter", herstellungsJahrFilter);
        return "index";
    }


    /**
     * Der Methode postNewSeil wird ein Seil Objekt übergeben und ein neues Seil wird erstellt.
     * Danach wird die Seite neu geladen.
     * @param newSeil
     * @return "redirect:/"
     */
    @PostMapping("/add")
    public String neuesSeilHinzufugen(@ModelAttribute Seil newSeil, Model model) {
        if (newSeil.getName().trim().isEmpty()) {
            model.addAttribute("seile", seilService.getAlleSeile());
            model.addAttribute("newSeil", newSeil);
            model.addAttribute("nameFehler", "Der Name darf nicht leer oder nur aus Leerzeichen bestehen.");
            return "index";
        }
        if (newSeil.getHerstellungsdatum().isAfter(newSeil.getAblaufdatum())) {
            model.addAttribute("seile", seilService.getAlleSeile());
            model.addAttribute("newSeil", newSeil);
            model.addAttribute("datumFehler", "Das Ablaufdatum muss nach dem Herstellungsdatum sein.");
            return "index";
        }
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
        seilService.deleteByName(name);
        return "redirect:/";
    }

    @GetMapping("/loeschen")
    public String loeschen(@RequestParam("id") long id, Model model) {
        String name = seilService.getNameById(id);
        model.addAttribute("loeschenName", name);
        return "loeschen";
    }

    @GetMapping("/bearbeiten")
    public String bearbeitenName(@RequestParam("id") long id, Model model) {
      Seil seil = seilService.getSeilById(id);
      model.addAttribute("seilBearbeiten", seil);
      return "bearbeiten";
    }

    @PostMapping("/update")
    public String seilBearbeiten(@ModelAttribute Seil seil, Model model) {
        if (seil.getName().trim().isEmpty()) {
            model.addAttribute("seile", seilService.getAlleSeile());
            model.addAttribute("seilBearbeiten", seil);
            model.addAttribute("nameFehler", "Der Name darf nicht leer oder nur aus Leerzeichen bestehen.");
            return "bearbeiten";
        }
        if (seil.getHerstellungsdatum().isAfter(seil.getAblaufdatum())) {
            model.addAttribute("seilBearbeiten", seil);
            model.addAttribute("datumFehler", "Das Ablaufdatum muss nach dem Herstellungsdatum liegen.");
            return "bearbeiten";
        }
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
