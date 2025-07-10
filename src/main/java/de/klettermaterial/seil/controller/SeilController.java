package de.klettermaterial.seil.controller;

import de.klettermaterial.seil.repository.SeilRepository;
import de.klettermaterial.seil.material.Seil;
import de.klettermaterial.seil.services.SeilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/seile")
public class SeilController {

    @Autowired
    private SeilRepository seilRepository; // Spring injiziert zur Laufzeit ein SeilRepo mit @Autowired. Also spring erzeig ein Objekt vom Typ SeilRepo.

    @Autowired
    private SeilService seilService;

    //readOne
    @GetMapping("/{id}")
    public Seil getSeilById(@PathVariable ("id") long id){
        return seilRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    //readAll
    @GetMapping()
    public Iterable<Seil> getAllSeile() {
        return seilService.getAlleSeile(); //seilservice aufrufen Und in seilservice fin
    }

    //CREATE
    @PostMapping
    public long postNewSeil(@RequestBody Seil newSeil) {
        System.out.println(newSeil);
        seilRepository.save(newSeil);
        return newSeil.getId();
    }

//    //add
//    @GetMapping("/add")
//    public String addNewSeil(Model model){
//        model.addAttribute("seil", new Seil());
//        return "add-Seil";
//    }


    //Endpunkt auf der Seite initdb wird diese Methode ausgeführt
    @GetMapping("/initdb")
    public String initdb(){
        seilRepository.deleteAll();
        Seil s1 = new Seil("Petzl DynamoXC", LocalDate.of(2020,1,1), LocalDate.of(2030,1,1), 0);
        Seil s2 = new Seil("Edelrid Tosh", LocalDate.of(2021,1,1), LocalDate.of(2031,1,1), 0);
        Seil s3 = new Seil("Beal Slim", LocalDate.of(2025,1,1), LocalDate.of(2035,1,1), 0);
        Seil s4 = new Seil("Mammut Zopa", LocalDate.of(2025,1,1), LocalDate.of(2035,1,1), 0);
        Seil s5 = new Seil("Petzl Dry Rope", LocalDate.of(2020,1,1), LocalDate.of(2030,1,1), 0);

        seilRepository.save(s1);
        seilRepository.save(s2);
        seilRepository.save(s3);
        seilRepository.save(s4);
        seilRepository.save(s5);

        return "Datenbank initalisiert";
    }
}
