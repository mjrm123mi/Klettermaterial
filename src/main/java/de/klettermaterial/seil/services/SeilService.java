package de.klettermaterial.seil.services;

import de.klettermaterial.seil.material.Seil;
import de.klettermaterial.seil.repository.SeilRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
     */
    public void neuesSeilHinzufuegen(Seil newSeil) {
        seilRepository.save(newSeil);
    }

    /**
     * Initialisiert die Datenbank mit Beispiel-Seilen.
     * @return "redirect:/"
     */
    public String initdb(){
        seilRepository.deleteAll();
        Seil s1 = new Seil("Petzl Dyno", LocalDate.of(2020,1,1), LocalDate.of(2029,1,1), 10);
        Seil s2 = new Seil("Edelrid Tosh", LocalDate.of(2021,1,1), LocalDate.of(2031,1,1), 5);
        Seil s3 = new Seil("Beal Slim", LocalDate.of(2025,1,1), LocalDate.of(2035,1,1), 0);
        Seil s4 = new Seil("Mammut", LocalDate.of(2025,1,1), LocalDate.of(2034,1,1), 12);
        Seil s5 = new Seil("Petzl Dry", LocalDate.of(2010,1,1), LocalDate.of(2020,1,1), 0);
        seilRepository.save(s1);
        seilRepository.save(s2);
        seilRepository.save(s3);
        seilRepository.save(s4);
        seilRepository.save(s5);
        return "redirect:/";
    }

    /**
     * Aktualisiert ein seil mit neuen Werten.
     * @param bearbeitetesSeil das bearbeitete Seil-Objekt mit neuen Werten
     */
    public void seilAktualisieren(Seil bearbeitetesSeil) {
    Seil original = seilRepository.findById(bearbeitetesSeil.getId())
                    .orElseThrow(() -> new RuntimeException("Seil nicht gefunden"));
    original.setName(bearbeitetesSeil.getName());
    original.setHerstellungsdatum(bearbeitetesSeil.getHerstellungsdatum());
    original.setAblaufdatum(bearbeitetesSeil.getAblaufdatum());
    original.setAbnutzungspunkte(bearbeitetesSeil.getAbnutzungspunkte());
    seilRepository.save(original);
    }

    public List<Seil> getAlleSeile() {
        return seilRepository.findAllByOrderByAblaufdatum();
    }


    @Transactional
    public void deleteByName(String name) {
        seilRepository.deleteByName(name);
    }

    public String getNameById(long id) {
        Seil seil = seilRepository.findById(id).orElseThrow(() -> new RuntimeException("Seil nicht gefunden"));
        return seil.getName();
    }

    public Seil getSeilById(long id) {
        Seil seil = seilRepository.findById(id).orElseThrow(() -> new RuntimeException("Seil nicht gefunden"));
        return seil;
    }

    public List<Seil> getSeileGefiltert(String nameFilter, String jahrFilter) {
        List<Seil> seile = seilRepository.findAllByOrderByAblaufdatum();

        if (nameFilter != null) {
          seile = seile.stream()
                  .filter(x -> x.getName().toLowerCase().contains(nameFilter.toLowerCase()))
                  .toList();
        } else {

        }
    }

    public List<Seil> getSeileNachJahr(Integer jahr) {
        if (jahr == null) {
            return seilRepository.findAllByOrderByAblaufdatum();
        }
        LocalDate start = LocalDate.of(jahr, 1, 1);
        LocalDate end = LocalDate.of(jahr, 12, 31);
        return seilRepository.findByHerstellungsdatumBetweenOrderByAblaufdatum(start, end);
    }



}
