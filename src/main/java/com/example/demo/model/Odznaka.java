package com.example.demo.model;
import javax.persistence.*;

@Entity
public class Odznaka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOdznaka;
    private String numerOdznaki;

    @OneToOne(mappedBy = "odznaka" , cascade ={CascadeType.ALL})
    Zwierze zwierze;


    public Zwierze getZwierze() {
        return zwierze;
    }

    public void setZwierze(Zwierze zwierze) {
        this.zwierze = zwierze;
    }

    public Odznaka(String numerOdznaki, Zwierze zwierze) {
        this.numerOdznaki = numerOdznaki;
        this.zwierze = zwierze;
    }


    public Odznaka(String numerOdznaki) {
        this.numerOdznaki = numerOdznaki;

    }
    public Odznaka() {
    }

    public String getNumerOdznaki() {
        return numerOdznaki;
    }

    public void setNumerOdznaki(String numerOdznaki) {
        this.numerOdznaki = numerOdznaki;
    }

    @Override
    public String toString() {
        return "Odznaka{" +
                "idOdznaka=" + idOdznaka +
                ", numerOdznaki='" + numerOdznaki + '\'' +
                 //   ", zwierze=" + zwierze +
                '}';
    }
}
