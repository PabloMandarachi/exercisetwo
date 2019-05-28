package com.exercisetwo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase entidad Class. Contiene los atributos de la clase y las
 * relaciones @ManyToOne con Teacher, @ManyToOne con Subject
 * 
 * @see Classe
 * @see Teacher
 * @see Subject
 * @author pmandara
 * @version 27/05/2019/A
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Classes")
public class Classe {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "class_id")
  private int classeId;
  @NotBlank(message = "Class code cannot be empty")
  @Size(min = 2, max = 10)
  @Column(name = "class_code")
  private String classCode;
  @NotBlank(message = "Class name cannot be empty")
  @Size(min = 2, max = 100)
  @Column(name = "class_name")
  private String className;
  
  @Temporal(TemporalType.DATE)
  @Column(name = "date_from")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota")
  private Date dateFrom;

  @Temporal(TemporalType.DATE)
  @Column(name = "date_to")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota")
  private Date dateTo;
  
  @ManyToOne
  @JoinColumn(name = "teacher_id")
  private Teacher teacher;

  @ManyToOne
  @JoinColumn(name = "subject_id")
  private Subject subject;

  // de uno a muchos
  @JsonIgnore
  @OneToMany(mappedBy = "classes")
  private List<StudentClass> studentClasses;
  
}
