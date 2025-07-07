package de.klettermaterial.seil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/seile")
public class SeilController {

    @Autowired
    private SeilRepository seile; // Spring injiziert zur Laufzeit ein SeilRepo mit @Autowired. Also spring erzeig ein Objekt vom Typ SeilRepo.

    /*
    @GetMapping
    public String hello() {
        return "Hallo Kletterin! Hier kannst du dein Kletterequipment verwalten";
    }
    */


    @GetMapping
    public Iterable<Seil> getAllSeile() {
        return seile.findAll();
    }

    @PostMapping
    public long postNewSeil(@RequestBody Seil newSeil) {
        System.out.println(newSeil);
        seile.save(newSeil);
        return newSeil.getId();
    }

    /*@PostMapping
    public String hellantwort() {
        return "Antwort";
    }*/
}
