package com.exercisetwo.service;

import com.exercisetwo.entity.Classe;
import java.util.List;
import java.util.Optional;

public interface IClasseService {

  List<Classe> findAll();

  Classe create(Classe classe);

  Classe update(Classe classe);

  int delete(Integer id);

  Optional<Classe> findByID(int id);
}
