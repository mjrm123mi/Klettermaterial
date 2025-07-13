package de.klettermaterial.seil.services;

import de.klettermaterial.seil.material.Seil;
import de.klettermaterial.seil.repository.SeilRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

/**
 * Service-Klasse für die Logik.
 */
@Service
public class SeilService {

    private final SeilRepository seilRepository;

    //Konstruktor Injektion weil Spring übrgibt automatisch ein Parameter an den Konstruktor
    //Spring ruft den Konstruktor auf.
    //Der Objektvaribale wird der Paramter zugewiesen.
    public SeilService(SeilRepository seilRepository) {
        this.seilRepository = seilRepository;
    }

    /**
     * Speichert ein neues Seil in der Datenbank.
     * @param newSeil Das zu speichernde Seil
     * @return Die ID des gespeicherten Seils
     */
    //CREATE UND SAVE
    public void neuesSeilHinzufuegen(Seil newSeil) {
       // System.out.println(newSeil);
        seilRepository.save(newSeil);
    }

    /**
     * Initialisiert die Datenbank mit Beispiel-Seilen.
     * @return "Datenbank initalisiert"
     */
    public String initdb(){
        seilRepository.deleteAll();
        Seil s1 = new Seil("Petzl Dyno", LocalDate.of(2020,1,1), LocalDate.of(2030,1,1), 0);
        Seil s2 = new Seil("Edelrid Tosh", LocalDate.of(2021,1,1), LocalDate.of(2031,1,1), 0);
        Seil s3 = new Seil("Beal Slim", LocalDate.of(2025,1,1), LocalDate.of(2035,1,1), 0);
        Seil s4 = new Seil("Mammut", LocalDate.of(2025,1,1), LocalDate.of(2035,1,1), 0);
        Seil s5 = new Seil("Petzl Dry", LocalDate.of(2020,1,1), LocalDate.of(2030,1,1), 0);

        seilRepository.save(s1);
        seilRepository.save(s2);
        seilRepository.save(s3);
        seilRepository.save(s4);
        seilRepository.save(s5);

        return "Datenbank initalisiert";
    }
}
