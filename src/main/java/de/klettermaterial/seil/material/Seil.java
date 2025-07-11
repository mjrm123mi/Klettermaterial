package de.klettermaterial.seil.material;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDate;

/**
 * Repräsentiert ein Kletterseil mit Eigenschaften wie Name, Herstellungsdatum, Ablaufdatum und Abnutzungspunkten.
 */
@Entity
public class Seil {
    /**
     * Eindeutige ID des Seils (Primärschlüssel, wird automatisch generiert).
     */
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private LocalDate herstellungsdatum;
    private LocalDate ablaufdatum;
    private int abnutzungspunkte;

    /**
     * Standard-Konstruktor (wird von Hibernate benötigt).
     */
    public Seil() {
        // (JPA ist die Spezifikation der Datenbankmagie
        // und Hibernate ist eine mögliche Implementaion davon. Und Spring verwendet Hibernate)
    }

    public Seil(String name, LocalDate herstellungsdatum, LocalDate ablaufdatum, int abnutzungspunkte) {
        this.name = name;
        this.herstellungsdatum = herstellungsdatum;
        this.ablaufdatum = ablaufdatum;
        this.abnutzungspunkte = abnutzungspunkte;
    }

    public int getAbnutzungspunkte() {
        return abnutzungspunkte;
    }

    public void setAbnutzungspunkte(int abnutzungspunkte) {
        this.abnutzungspunkte = abnutzungspunkte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String hersteller) {
        this.name = hersteller;
    }

    public LocalDate getHerstellungsdatum() {
        return herstellungsdatum;
    }

    public void setHerstellungsdatum(LocalDate herstellungsdatum) {
        this.herstellungsdatum = herstellungsdatum;
    }

    public LocalDate getAblaufdatum() {
        return ablaufdatum;
    }

    public void setAblaufdatum(LocalDate ablaufdatum) {
        this.ablaufdatum = ablaufdatum;
    }
}

