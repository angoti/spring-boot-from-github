package com.example.trabalho;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrabalhoApplication {

  private static final Logger log = LoggerFactory.getLogger(TrabalhoApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(TrabalhoApplication.class);
  }

  @Bean
  public CommandLineRunner demo(Repositorio repository) {
    return (args) -> {
    
      repository.save(new Cliente("Jack", "Bauer"));
      repository.save(new Cliente("Chloe", "O'Brian"));
      repository.save(new Cliente("Kim", "Bauer"));
      repository.save(new Cliente("David", "Palmer"));
      repository.save(new Cliente("Michelle", "Dessler"));

      
      log.info("Clientes encontrados():");
      log.info("-------------------------------");
      repository.findAll().forEach(customer -> {
        log.info(customer.toString());
      });
      log.info("");

    
      Cliente cliente = repository.findById(1L);
      log.info("Cliente encontrado por ID(1L):");
      log.info("--------------------------------");
      log.info(cliente.toString());
      log.info("");

      
      log.info("Cliente encontrado pelo nome('Bauer'):");
      log.info("--------------------------------------------");
      repository.findByLastName("Bauer").forEach(bauer -> {
        log.info(bauer.toString());
      });
      log.info("");
    };
  }

}