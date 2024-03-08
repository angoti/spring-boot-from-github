package com.example.trabalho;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface Repositorio extends CrudRepository<Cliente, Long> {

  List<Cliente> findByLastName(String lastName);

  Cliente findById(long id);
}
