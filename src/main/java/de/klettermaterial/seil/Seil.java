package de.klettermaterial.seil;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Seil {
    @Id
    @GeneratedValue
    private Long id;

    private String hersteller;
    private String modell;
    private String typ;
    private double durchmesser;
    private int laengeInMetern;
    private String herstellungsdatum;
    private String ablaufdatum;


    protected Seil() {
        //required by Hibernate
        // (JPA ist die Spezifikation der Datenbankmagie
        // und Hibernate ist eine mögliche Implementaion davon. Und Spring verwendet Hibernate)
    }

    public Seil(String hersteller, String modell, String typ, double durchmesser, int laengeInMetern, String herstellungsdatum, String ablaufdatum) {
        this.id = id;
        this.hersteller = hersteller;
        this.modell = modell;
        this.typ = typ;
        this.durchmesser = durchmesser;
        this.laengeInMetern = laengeInMetern;
        this.herstellungsdatum = herstellungsdatum;
        this.ablaufdatum = ablaufdatum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public int getLaengeInMetern() {
        return laengeInMetern;
    }

    public void setLaengeInMetern(int laengeInMetern) {
        this.laengeInMetern = laengeInMetern;
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

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public double getDurchmesser() {
        return durchmesser;
    }

    public void setDurchmesser(double durchmesser) {
        this.durchmesser = durchmesser;
    }
}
