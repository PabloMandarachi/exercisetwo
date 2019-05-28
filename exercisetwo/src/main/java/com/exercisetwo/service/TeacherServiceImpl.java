package com.exercisetwo.service;

import com.exercisetwo.dao.ITeacherDao;
import com.exercisetwo.entity.Teacher;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TeacherServiceImpl implements ITeacherService {

  Logger log = LoggerFactory.getLogger(this.getClass());
  
  @Autowired
  ITeacherDao dao;
  
  @Override
  public List<Teacher> findAll() {
    
    return (List<Teacher>) dao.findAll();
  }

  @Override
  public Teacher create(Teacher teacher) {
    
    return dao.save(teacher);
  }

  @Override
  public Teacher update(Teacher teacher) {
   
    return dao.save(teacher);
  }

  @Override
  public int delete(Integer id) {
    int rp = 0;
    try {
      dao.deleteById(id);
      rp = 1;
      log.info("Eleminado profesor");
    } catch (Exception e) {
      rp = 0;
      log.info("error" + e);
      log.info("no Eleminado profesor");
    }
    return rp;
  }

  @Override
  public Optional<Teacher> findByID(int id) {
    
    return dao.findById(id);
  }

}
