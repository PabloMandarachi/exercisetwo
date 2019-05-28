package com.exercisetwo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.lang.Nullable;

/**
 * Clase entidad Student. Contiene los atributos del estudiante y la
 * relación @ManyToMany con Class.
 * 
 * @see Student
 * 
 * @author pmandara
 * 
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Students")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int studentId;
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
  @Column(name = "date_of_birth")
  private Date dateOfBirth;
  @Nullable
  @Size(min = 2, max = 200)
  @Column(name = "other_student_details")
  private String otherStudentDetails;

  /**
  @JsonIgnore
  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(name = "Student_Classes",
             joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId"),
             inverseJoinColumns = @JoinColumn(name = "class_id",
                                              referencedColumnName = "classeId"))
  private Set<Classe> classes;
  **/
  /**
   * Contructor de Student para la relación @ManyToMany.
   * 
   * @param gender              Género
   * @param firstName           Primer nombre
   * @param middleName          Segundo nombre
   * @param lastName            Apellido
   * @param dateOfBirth         Fecha de nacimiento
   * @param otherStudentDetails Otros detalles de Student
   * @param classes             Colección de la clase Classes
   * 
   * @author pmandara
   * 
   */
  
  /**
  public Student(String gender, String firstName, String middleName, String lastName,
      Date dateOfBirth, String otherStudentDetails, Classe... classes) {
    this.gender = gender;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.otherStudentDetails = otherStudentDetails;
    this.classes = Stream.of(classes).collect(Collectors.toSet());
    this.classes.forEach(x -> x.getStudents().add(this));
  }**/

}
