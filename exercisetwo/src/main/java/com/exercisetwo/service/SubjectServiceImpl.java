package com.exercisetwo.service;

import com.exercisetwo.dao.ISubjectDao;
import com.exercisetwo.entity.Subject;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SubjectServiceImpl implements ISubjectService {

  Logger log = LoggerFactory.getLogger(this.getClass());
  
  @Autowired
  ISubjectDao dao;
  
  @Override
  public List<Subject> findAll() {
    
    return (List<Subject>) dao.findAll();
  }

  @Override
  public Subject create(Subject subject) {
    
    return dao.save(subject);
  }

  @Override
  public Subject update(Subject subject) {
   
    return dao.save(subject);
  }

  @Override
  public int delete(Integer id) {
    int rp = 0;
    try {
      dao.deleteById(id);
      rp = 1;
      log.info("Eleminado asignatura");
    } catch (Exception e) {
      rp = 0;
      log.info("error" + e);
      log.info("no Eleminado asignatura");
    }
    return rp;
  }

  @Override
  public Optional<Subject> findByID(int id) {
    
    return dao.findById(id);
  }

}
