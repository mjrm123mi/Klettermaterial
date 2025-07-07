package de.klettermaterial.seil;

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


    protected Seil() {
        //required by Hibernate
        // (JPA ist die Spezifikation der Datenbankmagie
        // und Hibernate ist eine mögliche Implementaion davon. Und Spring verwendet Hibernate)
    }

    public Seil(String hersteller, String modell, String typ, double durchmesser, int laengeInMetern, String herstellungsdatum, String ablaufdatum) {
        this.name = hersteller;
        this.herstellungsdatum = herstellungsdatum;
        this.ablaufdatum = ablaufdatum;
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
