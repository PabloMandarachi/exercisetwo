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
import org.springframework.lang.Nullable;

/**
 * Clase entidad Teacher. Contiene los atributos del profesor y la
 * relacion @OneToMany con Class
 * 
 * @see Teacher
 * @see Classe
 * @author pmandara
 * @version 27/05/2019/A
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Teachers")
public class Teacher {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "teacher_id")
  private int teacherId;
  @Column(name = "school_Id")
  private String schoolId;
  @Column(name = "gender")
  private String gender;
  @NotBlank(message = "First name cannot be empty")
  @Size(min = 2, max = 200)
  @Column(name = "first_name")
  private String firstName;
  @Nullable
  @Size(min = 2, max = 200)
  @Column(name = "middle_name")
  private String middleName;
  @NotBlank(message = "Last name cannot be empty")
  @Size(min = 2, max = 200)
  @Column(name = "last_name")
  private String lastName;
  @Nullable
  @Size(min = 2, max = 200)
  @Column(name = "other_teacher_details")
  private String otherReacherDetails;
  
  @JsonIgnore
  @OneToMany(mappedBy = "teacher")
  private List<Classe> classList;
  

}
