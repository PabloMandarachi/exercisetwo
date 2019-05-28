package com.exercisetwo.service;

import com.exercisetwo.dao.IClasseDao;
import com.exercisetwo.entity.Classe;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClasseServiceImpl implements IClasseService {

  Logger log = LoggerFactory.getLogger(this.getClass());
  
  @Autowired
  IClasseDao dao;
  
  @Override
  public List<Classe> findAll() {
    
    return (List<Classe>) dao.findAll();
  }

  @Override
  public Classe create(Classe classe) {
    
    return dao.save(classe);
  }

  @Override
  public Classe update(Classe classe) {
   
    return dao.save(classe);
  }

  @Override
  public int delete(Integer id) {
    int rp = 0;
    try {
      dao.deleteById(id);
      rp = 1;
      log.info("Eleminado clase");
    } catch (Exception e) {
      rp = 0;
      log.info("error" + e);
      log.info("no Eleminado clase");
    }
    return rp;
  }

  @Override
  public Optional<Classe> findByID(int id) {
    
    return dao.findById(id);
  }

}
