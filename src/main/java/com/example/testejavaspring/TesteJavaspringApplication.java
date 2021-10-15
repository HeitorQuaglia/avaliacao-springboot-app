package com.example.testejavaspring;

import com.example.testejavaspring.domain.Package;
import com.example.testejavaspring.domain.Status;
import com.example.testejavaspring.repositories.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class TesteJavaspringApplication implements CommandLineRunner {
    @Autowired
    PackageRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(TesteJavaspringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //clear table
        repository.deleteAll();

        Package pack1 = new Package();
        pack1.setDescription("iPhone 13");
        pack1.setLastUpdate(new Date());
        pack1.setPostDate(new Date());
        pack1.setCode("$1010");
        pack1.setCpf("20120220345");

        var status1 = new Status();
        status1.setCity("São Paulo");
        status1.setState("SP");
        status1.setComments("Objeto Postado");
        status1.setDate(new Date());

        var status2 = new Status();
        status2.setCity("São Paulo");
        status2.setState("SP");
        status2.setComments("Objeto saiu para entrega");
        status2.setDate(new Date());

        var history = new ArrayList<Status>();
        history.add(status1);
        history.add(status2);

        pack1.setHistory(history);


        Package pack2 = new Package();
        pack2.setDescription("MacBook Pro");
        pack2.setLastUpdate(new Date());
        pack2.setPostDate(new Date());
        pack2.setCode("$1011");
        pack2.setCpf("20120220345");

        var status3 = new Status();
        status3.setCity("São Paulo");
        status3.setState("SP");
        status3.setComments("Objeto Postado");
        status3.setDate(new Date());

        var status4 = new Status();
        status4.setCity("São Paulo");
        status4.setState("SP");
        status4.setComments("Objeto saiu para entrega");
        status4.setDate(new Date());

        var status5 = new Status();
        status5.setCity("São Paulo");
        status5.setState("SP");
        status5.setComments("Objeto Entregue ao Destinatário");
        status5.setDate(new Date());

        var history2 = new ArrayList<Status>();
        history2.add(status3);
        history2.add(status4);
        history2.add(status5);

        pack2.setHistory(history2);

        repository.save(pack1);
        repository.save(pack2);
    }
}
