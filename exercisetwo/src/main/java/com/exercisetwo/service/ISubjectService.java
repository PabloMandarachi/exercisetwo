package com.exercisetwo.service;

import com.exercisetwo.entity.Subject;
import java.util.List;
import java.util.Optional;


public interface ISubjectService {
	
  List<Subject> findAll();

  Subject create(Subject subject);

  Subject update(Subject subject);

  int delete(Integer id);
  
  Optional<Subject> findByID(int id);
}
