package com.example.demo.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Zoo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idZoo;
    private String nazwaZoo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="zoo",
            fetch = FetchType.EAGER)
    private List<Zwierze> zwierza;

    public Zoo(String nazwaZoo) {
        this.nazwaZoo = nazwaZoo;
        this.zwierza =new ArrayList<>();
    }

    public void setNazwaZoo(String nazwaZoo) {
        this.nazwaZoo = nazwaZoo;
    }

    public Zoo() {
    }

    public List<Zwierze> getZwierza() {
        return zwierza;
    }

    public void setZwierza(List<Zwierze> zwierza) {
        this.zwierza = zwierza;
    }

    public Integer getIdZoo() {
        return idZoo;
    }

    public void setIdZoo(Integer idZoo) {
        this.idZoo = idZoo;
    }

    public String getNazwaZoo() {
        return nazwaZoo;
    }
//    public void wypelniamyKolekcjeZwierzetami(Zwierze zwierze) {
//
//        zwierza.add(zwierze);
//
//    }


    @Override
    public String toString() {
        return "Zoo{" +
                "idZoo=" + idZoo +
                ", nazwaZoo='" + nazwaZoo + '\'' +
//                ", zwierza=" + zwierza +
                '}';
    }
}
