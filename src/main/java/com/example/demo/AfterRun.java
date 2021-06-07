package com.example.demo;
import com.example.demo.model.*;
import com.example.demo.model.Odznaka;
import com.example.demo.model.Zoo;
import com.example.demo.model.Zwierze;
import com.example.demo.repository.ZooRepository;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component

public class AfterRun {

//    public static Zoo wroclawskie;

    ZooRepository zooRepository;
    ZwierzeRepository zwierzeRepository;
    OdznakaRepository odznakaRepository;
    @Autowired
    public void AfterRun(
            ZooRepository zooRepository,
            ZwierzeRepository zwierzeRepository, OdznakaRepository odznakaRepository){

        this.zooRepository = zooRepository;
        this.zwierzeRepository = zwierzeRepository;
        this.odznakaRepository = odznakaRepository;

    }

    @EventListener(ApplicationReadyEvent.class)
    public void anyWihoutName(){

       Zoo zoo1 =new Zoo("Warszawskie");

        List<Zwierze> zwierzeList = Arrays.asList(
                new Zwierze("Amurski", "Lampart", "11", zoo1),
                new Zwierze("Łysy", "Orzeł", "22", zoo1),
                new Zwierze("Ognista", "Salamandra", "33", zoo1),
                new Zwierze("Birmański", "Pyton", "44", zoo1));

        zoo1.setZwierza(zwierzeList);

        zooRepository.save(zoo1);


        List<Zoo> ZooFromBase= zooRepository.findAll();

        for (Zoo zoo : ZooFromBase) {
            System.out.println(zoo.getZwierza());
        }


        List<Zwierze> ZwierzeFromBase= zwierzeRepository.findAll();

        for (Zwierze zwierze: ZwierzeFromBase) {
            System.out.println(zwierze);
        }
        System.out.println("Rodzaj: "+ZwierzeFromBase.get(1).getRodzaj()+", ");
        System.out.println("Nazwa: "+ZwierzeFromBase.get(1).getNazwa());
        System.out.println("NumerOdznaki: "+ZwierzeFromBase.get(1).getNumerOdznaki());
        System.out.println("NazwaZoo: "+ZwierzeFromBase.get(1).getNazwaZoo());

        System.out.println(zooRepository.findAll());


        System.out.println(ZwierzeFromBase);


//        Odznaka odznaka = new Odznaka("98");
//        Zwierze zwierze = new Zwierze("Amurski", "Lampart");
//        zwierze.setOdznaka(odznaka);
//        odznaka.setZwierze(zwierze);
//        zwierzeRepository.save(zwierze);
//        odznakaRepository.save(odznaka);

//
//        System.out.println("Nazwa zwierza z odznaki "+ odznaka.getNumerOdznaki()+" to: "+ odznaka.getZwierze().getNazwa());
//        System.out.println("-------dane z bazy:------------");
//        System.out.println("Odznaka:"+ odznakaRepository.findAll());
//        System.out.println("-------------------");
//        System.out.println("Zwierze:"+ zwierzeRepository.findAll());
//        System.out.println(zwierze);


//        Odznaka odznaka2 = new Odznaka("52");
//        Zwierze zwierze2 = new Zwierze("Ptak", "Orzeł", "52");
//        zwierze2.setOdznaka(odznaka2);
//        odznaka2.setZwierze(zwierze2);
//        zwierzeRepository.save(zwierze2);



//
//        System.out.println("-------dane z bazy:------------");
//        System.out.println("Odznaka:"+ odznakaRepository.findAll());
//        System.out.println("-------------------");
//        System.out.println("Zoo:"+ zooRepository.findAll());
//        System.out.println("-------------------");
//        System.out.println("Zwierze:"+ zwierzeRepository.findAll());
//
//
//        System.out.println("Wyświetlamy dane z poziomu odznaki o jej zwierza ");
//        for (Odznaka odznaczka : odznakaRepository.findAll()) {
//            System.out.println(odznaczka.getZwierze());
//        }



//        System.out.println(odznakaRepository.findByNumerOdznaki("98").getZwierze().getNazwa());
//        System.out.println(odznakaRepository.findByNumerOdznaki("52").getZwierze().getNazwa());


//        Zoo warszawskie = new Zoo("Warszawskie");
//        Zoo lodzkie = new Zoo("Lodzkie");
//        Zoo poznanskie = new Zoo("Poznanskie");
//
//        zooRepository.save(warszawskie);
//        zooRepository.save(lodzkie);
//        zooRepository.save(poznanskie);



    }



}
