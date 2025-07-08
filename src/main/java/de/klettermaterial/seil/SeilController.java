package de.klettermaterial.seil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seile")
public class SeilController {

    @Autowired
    private SeilRepository seilRepository; // Spring injiziert zur Laufzeit ein SeilRepo mit @Autowired. Also spring erzeig ein Objekt vom Typ SeilRepo.

    //readOne
    @GetMapping("/{id}")
    public Seil getSeilById(@PathVariable ("id") long id){
        return seilRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    //readAll
    @GetMapping()
    public Iterable<Seil> getAllSeile() {
        return seilRepository.findAll();
    }

    //CREATE
    @PostMapping
    public long postNewSeil(@RequestBody Seil newSeil) {
        System.out.println(newSeil);
        seilRepository.save(newSeil);
        return newSeil.getId();
    }

    //Endpunkt auf der Seite initdb wird diese Methode ausgeführt
    @GetMapping("/initdb")
    public void initdb(){
        seilRepository.deleteAll();
        Seil s1 = new Seil("Petzl DynamoXC", "01.01.2020", "01.01.2030", 0);
        Seil s2 = new Seil("Edelrid Tosh", "01.01.2020", "01.01.2030", 0);
        Seil s3 = new Seil("Beal Slim", "01.01.2025", "01.01.2035", 0);
        Seil s4 = new Seil("Mammut Zopa", "01.01.2025", "01.01.2035", 0);
        Seil s5 = new Seil("Petzl Dry Rope", "01.01.2024", "01.01.2034", 0);

        seilRepository.save(s1);
        seilRepository.save(s2);
        seilRepository.save(s3);
        seilRepository.save(s4);
        seilRepository.save(s5);
    }
}
