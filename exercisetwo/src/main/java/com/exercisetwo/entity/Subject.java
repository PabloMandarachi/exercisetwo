package com.exercisetwo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase entidad Subject. Contiene los atributos de la asignatura y la
 * relacion @OneToMany con Class
 * 
 * @see Subject
 * @see Classe
 * @author pmandara
 * @version 27/05/2019/A
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Subjects")
public class Subject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int subjectId;
  @NotBlank(message = "Subject name cannot be empty")
  @Size(min = 2, max = 200)
  @Column(name = "subject_name")
  private String subjectName;
  
  @JsonIgnore
  @OneToMany(mappedBy = "subject")
  private List<Classe> classList;
}
