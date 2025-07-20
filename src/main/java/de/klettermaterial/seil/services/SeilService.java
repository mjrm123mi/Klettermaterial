package de.klettermaterial.seil.services;

import de.klettermaterial.seil.material.Seil;
import de.klettermaterial.seil.repository.SeilRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public String initdb() {
        seilRepository.deleteAll();
        Seil s1 = new Seil("Petzl Dyno", LocalDate.of(2020, 1, 1), LocalDate.of(2029, 1, 1), 10);
        Seil s2 = new Seil("Edelrid Tosh", LocalDate.of(2021, 1, 1), LocalDate.of(2031, 1, 1), 5);
        Seil s3 = new Seil("Beal Slim", LocalDate.of(2025, 1, 1), LocalDate.of(2035, 1, 1), 0);
        Seil s4 = new Seil("Mammut", LocalDate.of(2025, 1, 1), LocalDate.of(2034, 1, 1), 12);
        Seil s5 = new Seil("Petzl Dry", LocalDate.of(2010, 1, 1), LocalDate.of(2020, 1, 1), 0);
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
        seilRepository.save(bearbeitetesSeil);
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

    public List<Seil> getSeileGefiltert(String nameFilter, Integer herstellungsJahrFilter) {
        List<Seil> seile = seilRepository.findAllByOrderByAblaufdatum();
        if (nameFilter != null) {
            seile = seile.stream()
                    .filter(x -> x.getName().toLowerCase().contains(nameFilter.toLowerCase()))
                    .toList();
        }
        if (herstellungsJahrFilter != null) {
            seile = seile.stream()
                    .filter(x -> x.getHerstellungsdatum().getYear() == herstellungsJahrFilter)
                    .toList();
        }
       return seile;
    }

    public List<String> validiereSeil(Seil seil) {
        List<String> fehler = new ArrayList<>();
        if (seil.getName().trim().isEmpty()) {
            fehler.add("Der Name darf nicht leer oder nur aus Leerzeichen bestehen.");
        }
        if (seil.getHerstellungsdatum().isAfter(seil.getAblaufdatum())) {
            fehler.add("Das Ablaufdatum muss nach dem Herstellungsdatum sein.");
        }
        return fehler;
    }
}
