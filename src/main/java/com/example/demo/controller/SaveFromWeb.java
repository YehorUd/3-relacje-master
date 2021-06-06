package com.example.demo.controller;
import com.example.demo.model.Odznaka;
import com.example.demo.model.Zoo;
import com.example.demo.model.Zwierze;
import com.example.demo.repository.ZooRepository;
import com.example.demo.repository.ZwierzeRepository;
import com.example.demo.repository.OdznakaRepository;
import org.springframework.web.bind.annotation.*;


@RestController
public class SaveFromWeb {

    private ZwierzeRepository zwierzeRepository;
    private OdznakaRepository odznakaRepository;
    private ZooRepository zooRepository;
//    Zoo wroclawskie = new Zoo("Wrocławskie");


    public SaveFromWeb (ZwierzeRepository zwierzeRepository, OdznakaRepository odznakaRepository
                        , ZooRepository zooRepository
    ) {
        this.zwierzeRepository = zwierzeRepository;
        this.odznakaRepository = odznakaRepository;
               this.zooRepository = zooRepository;
    }

    @RequestMapping("/zooSave")
    public String dodajemyDane(
            @RequestParam("nazwaZoo") String nazwaZoo){

          zooRepository.save(new Zoo(nazwaZoo));
        return "Dodałem zoo do bazy";
    }


    @RequestMapping("/save")
    public String dodajemyDane(
            @RequestParam("rodzaj") String rodzaj,
            @RequestParam("nazwa") String nazwa,
            @RequestParam("numerOdznaki") String numerOdznaki)  throws Exception
    {



        Odznaka odznaka = new Odznaka(numerOdznaki);
        Zwierze zwierze = new Zwierze(rodzaj, nazwa, numerOdznaki);



        odznaka.setZwierze(zwierze);
        zwierze.setOdznaka(odznaka);
        odznakaRepository.save(odznaka);
        zwierzeRepository.save(zwierze);



//         wroclawskie.wypelniamyKolekcjeZwierzetami(zwierze);
//          zooRepository.save(wroclawskie);


        System.out.println("-------------------");
        System.out.println(zwierze);

        System.out.println("-------------------");


        System.out.println(zwierze.getNumerOdznaki());
        System.out.println(zwierze.getNazwaZoo());



        return "zwierze: "+zwierze;
    }
}
