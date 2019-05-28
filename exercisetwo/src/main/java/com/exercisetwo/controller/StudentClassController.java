package com.exercisetwo.controller;

import com.exercisetwo.exception.ModeloNotFoundException;
import com.exercisetwo.service.IStudentClassService;
import com.exercisetwo.entity.StudentClass;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Spring Boot Swagger rest", description = "Mostar información")
@RestController
public class StudentClassController {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private IStudentClassService service;

  /**
   * La función listStudentClasss() retorna la lista de StudentClasss.
   * 
   * @return list of StudentClasss.
   */
  @ApiOperation(value = "Retorna lista de StudentClasss")
  @GetMapping(value = "/api/2.0/StudentClass") 
  public ResponseEntity<List<StudentClass>> listStudentClass() {
	  return new ResponseEntity<List<StudentClass>>(service.findAll(),HttpStatus.OK);
  }


  /**
   * La función createStudentClasss() se encarga de registrar a un objeto StudentClasss.
   * 
   * @param teach object StudentClasss.
   * @return object StudentClasss.
   */
  @ApiOperation(value = "Crea a un profesor")
  @PostMapping(value = "/api/2.0/StudentClass", consumes = "application/json", 
      produces = "application/json")
  public ResponseEntity<StudentClass> createStudentClass(@RequestBody StudentClass teach) {

    return new ResponseEntity<StudentClass>(service.create(teach), HttpStatus.CREATED);
  }

  /**
   * La función updateStudentClasss() se encarga de actualizar a un objeto StudentClasss.
   * 
   * @param teach object StudentClasss.
   * @return object StudentClasss.
   */
  @ApiOperation(value = "Actualiza un profesor")
  @PutMapping(value = "/api/2.0/StudentClass", consumes = "application/json", 
        produces = "application/json")
  public ResponseEntity<StudentClass> updateStudentClass(@RequestBody StudentClass teach) {
    String mensaje = "";
    Optional<StudentClass> tea = service.findByID(teach.getDateFrom());

    if (tea.isPresent()) {
      return new ResponseEntity<StudentClass>(service.update(teach), HttpStatus.OK);
    } else {
      mensaje = "error " + teach.getDateFrom();
      throw new ModeloNotFoundException(mensaje);
    }
  }

  /**
   * La función deleteStudentClasss() se encarga de remover a un objeto StudentClasss por su
   * código.
   * 
   * @param teach Update.
   * @return object families delete.
   */
  /**
  @ApiOperation(value = "Elimina datos de un profesor")
  @DeleteMapping(value = "/api/2.0/StudentClass", consumes = "application/json", 
          produces = "application/json")
  public ResponseEntity<Integer> deleteStudentClass(@RequestBody StudentClass teach) {
    Date rp = null;
    String mensaje = "";

    Optional<StudentClass> fa = service.findByID(teach.getDateFrom());

    if (fa.isPresent()) {
      log.info("id " + teach.getDateFrom());
      rp = service.delete(teach.getDateFrom());
      return new ResponseEntity<Date>(rp, HttpStatus.OK);
    } else {
      mensaje = "error ID " + teach.getDateFrom();
      throw new ModeloNotFoundException(mensaje);
    }
  }  **/

  /**
   * La función listById() se le envia un parametro id y retorna a la StudentClasss de
   * ese id.
   * 
   * @param id parametro de filtro.
   * @return StudentClass.
   */
  @ApiOperation(value = "Retorna inforacion de profesor  por su Id")
  @GetMapping(value = "/api/2.0/StudentClass/{id}")
  public ResponseEntity<Object> listById(@PathVariable("id") Date id) {

    String mensaje = "";
    Optional<StudentClass> teach = service.findByID(id);

    if (teach.isPresent()) {
      return new ResponseEntity<Object>(teach, HttpStatus.OK);
    } else {
      mensaje = "error  " + id;
      throw new ModeloNotFoundException(mensaje);
    }
  }

}
