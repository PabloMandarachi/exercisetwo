package com.exercisetwo.service;

import com.exercisetwo.dao.IStudentClassDao;
import com.exercisetwo.entity.StudentClass;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentClassServiceImpl implements IStudentClassService {

  Logger log = LoggerFactory.getLogger(this.getClass());
  
  @Autowired
  IStudentClassDao dao;
  
  @Override
  public List<StudentClass> findAll() {
    
    return (List<StudentClass>) dao.findAll();
  }

  @Override
  public StudentClass create(StudentClass studentClass) {
    
    return dao.save(studentClass);
  }

  @Override
  public StudentClass update(StudentClass studentClass) {
   
    return dao.save(studentClass);
  }
  /**
  @Override
  public Date delete(Date id) {
    Date rp = "";
    try {
      dao.deleteById(id);
      rp <> null;
      log.info("Eleminado student_clase");
    } catch (Exception e) {
      rp = null;
      log.info("error" + e);
      log.info("no Eleminado student_clase");
    }
    return rp;
  }**/

  @Override
  public Optional<StudentClass> findByID(Date id) {
    
    return dao.findById(id);
  }

  @Override
  public Date delete(Date id) {
    // TODO Auto-generated method stub
    return null;
  }

}
