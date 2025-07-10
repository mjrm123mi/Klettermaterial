package de.klettermaterial.seil.services;

import de.klettermaterial.seil.controller.SeilController;
import de.klettermaterial.seil.material.Seil;
import de.klettermaterial.seil.repository.SeilRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Service-Klasse für die Logik.
 */
@Service
public class SeilService {

    private final SeilRepository seilRepository;

    public SeilService(SeilRepository seilRepository) {
        this.seilRepository = seilRepository;
    }

    /**
     * Gibt ein Seil anhand der ID zurück.
     * @param id Seil-ID
     * @return Gefundenes Seil
     * @throws IllegalArgumentException falls kein Seil gefunden wurde
     */
    //readOne
    @GetMapping("/{id}")
    public Seil getSeilById(@PathVariable("id") long id){
        return seilRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    /**
     * Speichert ein neues Seil in der Datenbank.
     * @param newSeil Das zu speichernde Seil
     * @return Die ID des gespeicherten Seils
     */
    //CREATE
    @PostMapping
    public long postNewSeil(@RequestBody Seil newSeil) {
        System.out.println(newSeil);
        seilRepository.save(newSeil);
        return newSeil.getId();
    }

    /**
     * Initialisiert die Datenbank mit Beispiel-Seilen.
     * @return "Datenbank initalisiert"
     */
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

    /**
     * Fügt ein Seil hinzu.
     * @param seil Das hinzuzufügende Seil
     */
    public void addSeil(Seil seil) {
        seilRepository.save(seil);
    }


    /**
     * Gibt die Anzahl aller Seile zurück.
     * @return Anzahl der Seile
     */
    public long numberOfSeile() {
        return seilRepository.count();
    }

    /**
     * Gibt eine Liste von Seilen eines übergebenen Herstellers zurück.
     * @param hersteller Name des Herstellers
     * @return Liste der Seile vom Hersteller
     */
    public List<Seil> seileVomHersteller(String hersteller) {
        return StreamSupport.stream(seilRepository.findAll().spliterator(), false)
                .filter(seil -> seil.getName().equals(hersteller))
                .collect(Collectors.toList());
    }

    /**
     * Gibt alle Seile zurück.
     * @return Iterable aller Seile
     */
    public Iterable<Seil> getAlleSeile() {
        return seilRepository.findAll();
    }
}
