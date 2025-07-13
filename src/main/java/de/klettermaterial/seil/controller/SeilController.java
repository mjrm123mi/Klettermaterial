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
     * SeilService wird aufgerufen und Datenbank initalisiert.
     */
    @GetMapping("/initdb")
    public String initdb(){
        return seilService.initdb();
    }

}
