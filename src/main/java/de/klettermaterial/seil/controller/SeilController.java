package de.klettermaterial.seil.controller;

import de.klettermaterial.seil.material.Seil;
import de.klettermaterial.seil.services.SeilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seile")
public class SeilController {

    @Autowired
    private SeilService seilService;

    //readOne
    @GetMapping("/{id}")
    public Seil getSeilById(@PathVariable ("id") long id){
        return seilService.getSeilById(id);
    }

    //readAll
    @GetMapping()
    public Iterable<Seil> getAllSeile() {
        return seilService.getAlleSeile(); //seilservice aufrufen Und in seilservice fin
    }

    //richtig so???
    //CREATE
    @PostMapping
    public long postNewSeil(@RequestBody Seil newSeil) {
        return seilService.postNewSeil(newSeil);
    }

    //seilService aufrufen und Datenbank initalisieren
    @GetMapping("/initdb")
    public String initdb(){
        return seilService.initdb();
    }

}
