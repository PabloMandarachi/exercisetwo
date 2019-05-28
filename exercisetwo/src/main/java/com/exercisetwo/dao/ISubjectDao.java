package com.exercisetwo.dao;

import com.exercisetwo.entity.Subject;

import org.springframework.data.repository.CrudRepository;

public interface ISubjectDao  extends  CrudRepository<Subject, Integer> {

}
