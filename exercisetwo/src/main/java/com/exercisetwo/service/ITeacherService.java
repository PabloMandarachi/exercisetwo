package com.exercisetwo.service;

import com.exercisetwo.entity.Teacher;
import java.util.List;
import java.util.Optional;


public interface ITeacherService {
	
  List<Teacher> findAll();

  Teacher create(Teacher teacher);

  Teacher update(Teacher teacher);

  int delete(Integer id);
  
  Optional<Teacher> findByID(int id);
}
