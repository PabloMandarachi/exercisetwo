package com.exercisetwo.service;

import com.exercisetwo.entity.StudentClass;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IStudentClassService {
  List<StudentClass> findAll();

  StudentClass create(StudentClass studentClass);

  StudentClass update(StudentClass studentClass);

  Date delete(Date id);

  Optional<StudentClass> findByID(Date id);
}
