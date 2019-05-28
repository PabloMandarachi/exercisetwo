package com.exercisetwo.dao;

import com.exercisetwo.entity.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeacherDao extends CrudRepository<Teacher,Integer> {

}
