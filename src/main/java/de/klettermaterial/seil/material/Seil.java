package de.klettermaterial.seil.material;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Seil {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String herstellungsdatum;
    private String ablaufdatum;
    private int abnutzungspunkte;


    public Seil() {
        //required by Hibernate
        // (JPA ist die Spezifikation der Datenbankmagie
        // und Hibernate ist eine mögliche Implementaion davon. Und Spring verwendet Hibernate)
    }

    public Seil(String name, String herstellungsdatum, String ablaufdatum, int abnutzungspunkte) {
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

    public String getHerstellungsdatum() {
        return herstellungsdatum;
    }

    public void setHerstellungsdatum(String herstellungsdatum) {
        this.herstellungsdatum = herstellungsdatum;
    }

    public String getAblaufdatum() {
        return ablaufdatum;
    }

    public void setAblaufdatum(String ablaufdatum) {
        this.ablaufdatum = ablaufdatum;
    }
}

