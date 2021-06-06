package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Zwierze {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idZwierze;
    private String rodzaj;
    private String nazwa;



    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="odznakaID")
    private Odznaka odznaka;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="zoo")
    private Zoo zoo;


    public Zwierze(String rodzaj, String nazwa, String numerOdznaki) {
        this.rodzaj = rodzaj;
        this.nazwa = nazwa;
        this.odznaka = new Odznaka(numerOdznaki);
    }

//    public Zwierze(String rodzaj, String nazwa, String numerOdznaki, String zoo) {
//        this.rodzaj = rodzaj;
//        this.nazwa = nazwa;
//        this.odznaka = new Odznaka(numerOdznaki);
//        this.zoo = new Zoo(zoo);
//    }

    public Zwierze(String rodzaj, String nazwa, Odznaka obiektOdznaka) {
        this.rodzaj = rodzaj;
        this.nazwa = nazwa;
        this.odznaka = obiektOdznaka;
    }

    public Zwierze(String rodzaj, String nazwa) {
        this.rodzaj = rodzaj;
        this.nazwa = nazwa;
    }


public Zwierze(String rodzaj, String nazwa, String numerOdznaki, Zoo zoo1) {
    this.rodzaj = rodzaj;
    this.nazwa = nazwa;
    this.odznaka = new Odznaka(numerOdznaki);
    this.zoo = zoo1;
}

    public Zwierze() {
    }

    public Integer getIdZwierze() {
        return idZwierze;
    }

    public void setIdZwierze(Integer idZwierze) {
        this.idZwierze = idZwierze;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Odznaka getNumerOdznaki() {
        return odznaka;
    }
    public Odznaka getNazwaZoo() {
        return odznaka;
    }

    public void setNumerOdznaki(Odznaka numerOdznaki) {
        this.odznaka = numerOdznaki;
    }

    @Override
    public String toString() {
        return "Zwierze{" +
                "id=" + idZwierze +
                ", rodzaj='" + rodzaj + '\'' +
                ", nazwa='" + nazwa + '\'' +
                ", numerOdznaki=" + odznaka +
                ", zoo=" + zoo +
                '}';
    }

    public Odznaka getOdznaka() {
        return odznaka;
    }

    public void setOdznaka(Odznaka odznaka) {
        this.odznaka = odznaka;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }


}



