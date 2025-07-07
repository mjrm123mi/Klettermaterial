package de.klettermaterial.seil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seile")
public class SeilController {

    @Autowired
    private SeilRepository seile; // Spring injiziert zur Laufzeit ein SeilRepo mit @Autowired. Also spring erzeig ein Objekt vom Typ SeilRepo.

    @GetMapping("/{id}")
    public Seil getSeilById(@PathVariable ("id") long id){
        return seile.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @GetMapping()
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
