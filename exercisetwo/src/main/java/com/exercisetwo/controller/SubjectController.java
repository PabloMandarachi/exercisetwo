package com.exercisetwo.controller;

import com.exercisetwo.exception.ModeloNotFoundException;
import com.exercisetwo.service.ISubjectService;
import com.exercisetwo.entity.Subject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Spring Boot Swagger rest", description = "Mostar información")
@RestController
public class SubjectController {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private ISubjectService service;

  /**
   * La función listSubjects() retorna la lista de Subjects.
   * 
   * @return list of Subjects.
   */
  @ApiOperation(value = "Retorna lista de Subjects")
  @GetMapping(value = "/api/2.0/Subjects") 
  public ResponseEntity<List<Subject>> listSubjects() {
	  return new ResponseEntity<List<Subject>>(service.findAll(),HttpStatus.OK);
  }


  /**
   * La función createSubjects() se encarga de registrar a un objeto Subjects.
   * 
   * @param subject object Subjects.
   * @return object Subjects.
   */
  @ApiOperation(value = "Crea a un profesor")
  @PostMapping(value = "/api/2.0/Subjects", consumes = "application/json", 
      produces = "application/json")
  public ResponseEntity<Subject> createSubjects(@RequestBody Subject subject) {

    return new ResponseEntity<Subject>(service.create(subject), HttpStatus.CREATED);
  }

  /**
   * La función updateSubjects() se encarga de actualizar a un objeto Subjects.
   * 
   * @param subject object Subjects.
   * @return object Subjects.
   */
  @ApiOperation(value = "Actualiza un profesor")
  @PutMapping(value = "/api/2.0/Subjects", consumes = "application/json", 
        produces = "application/json")
  public ResponseEntity<Subject> updateSubjects(@RequestBody Subject subject) {
    String mensaje = "";
    Optional<Subject> tea = service.findByID(subject.getSubjectId());

    if (tea.isPresent()) {
      return new ResponseEntity<Subject>(service.update(subject), HttpStatus.OK);
    } else {
      mensaje = "error " + subject.getSubjectId();
      throw new ModeloNotFoundException(mensaje);
    }
  }

  /**
   * La función deleteSubjects() se encarga de remover a un objeto Subjects por su
   * código.
   * 
   * @param subject Update.
   * @return object families delete.
   */
  @ApiOperation(value = "Elimina datos de un profesor")
  @DeleteMapping(value = "/api/2.0/Subjects", consumes = "application/json", 
          produces = "application/json")
  public ResponseEntity<Integer> deleteSubjects(@RequestBody Subject subject) {
    int rp = 0;
    String mensaje = "";

    Optional<Subject> fa = service.findByID(subject.getSubjectId());

    if (fa.isPresent()) {
      log.info("id " + subject.getSubjectId());
      rp = service.delete(subject.getSubjectId());
      return new ResponseEntity<Integer>(rp, HttpStatus.OK);
    } else {
      mensaje = "error ID " + subject.getSubjectId();
      throw new ModeloNotFoundException(mensaje);
    }
  }

  /**
   * La función listById() se le envia un parametro id y retorna a la Subjects de
   * ese id.
   * 
   * @param id parametro de filtro.
   * @return Subject.
   */
  @ApiOperation(value = "Retorna inforacion de profesor  por su Id")
  @GetMapping(value = "/api/2.0/Subjects/{id}")
  public ResponseEntity<Object> listById(@PathVariable("id") Integer id) {

    String mensaje = "";
    Optional<Subject> subject = service.findByID(id);

    if (subject.isPresent()) {
      return new ResponseEntity<Object>(subject, HttpStatus.OK);
    } else {
      mensaje = "error  " + id;
      throw new ModeloNotFoundException(mensaje);
    }
  }

}
