package com.exercisetwo.dao;

import com.exercisetwo.entity.StudentClass;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

public interface IStudentClassDao extends  CrudRepository<StudentClass, Date> {

}
