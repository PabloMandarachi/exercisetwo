package com.exercisetwo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase entidad Students_class. Contiene los atributos de la relacion entre estudiante y class y la
 * relación @ManyToMany con Class.
 * 
 * @see StudentClass
 * 
 * @author pmandara
 * 
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@IdClass (PkStudentClass.class)
public class StudentClass {
	
  @Id
  private Date dateFrom;
  
  // de muchos a uno
  @Id
  private Student students;

  // nuchos a uno
  @Id
  private Classe classes;
  
  

  @Temporal(TemporalType.DATE)
  @Column(name = "date_to")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota")
  private Date dateTo;

}
