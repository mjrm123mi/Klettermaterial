package de.klettermaterial.seil.controller;

import de.klettermaterial.seil.material.Seil;
import de.klettermaterial.seil.services.SeilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * REST-Controller für Seil-bezogene Endpunkte.
 * Leitet HTTP-Anfragen an den SeilService weiter.
 */
@RestController
@RequestMapping("/seile")
public class SeilController {

    @Autowired
    private SeilService seilService;

    /**
     * Gibt ein Seil anhand der ID zurück.
     */
    //readOne
    @GetMapping("/{id}")
    public Seil getSeilById(@PathVariable ("id") long id){
        return seilService.getSeilById(id);
    }

    /**
     * Gibt alle Seile zurück.
     */
    //readAll
    @GetMapping()
    public Iterable<Seil> getAllSeile() {
        return seilService.getAlleSeile(); //seilservice aufrufen Und in seilservice fin
    }

    /**
     * Erstellt ein SeilObjekt und speichert es in der Datenbank.
     */
    //CREATE und SAVE
    @PostMapping
    public void postNewSeil(@RequestBody Seil newSeil) {
         seilService.postNewSeil(newSeil);
    }

    /**
     * SeilService wird aufgerufen und Datenbank initalisiert.
     */
    @GetMapping("/initdb")
    public String initdb(){
        return seilService.initdb();
    }

}
