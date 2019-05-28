package com.exercisetwo.dao;

import com.exercisetwo.entity.Classe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClasseDao extends  CrudRepository<Classe, Integer> {

}
