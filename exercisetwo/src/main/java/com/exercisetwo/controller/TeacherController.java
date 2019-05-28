package com.exercisetwo.controller;

import com.exercisetwo.exception.ModeloNotFoundException;
import com.exercisetwo.service.ITeacherService;
import com.exercisetwo.entity.Teacher;

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
public class TeacherController {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private ITeacherService service;

  /**
   * La función listTeachers() retorna la lista de Teachers.
   * 
   * @return list of Teachers.
   */
  @ApiOperation(value = "Retorna lista de Teachers")
  @GetMapping(value = "/api/2.0/teachers") 
  public ResponseEntity<List<Teacher>> listTeachers() {
	  return new ResponseEntity<List<Teacher>>(service.findAll(),HttpStatus.OK);
  }


  /**
   * La función createTeachers() se encarga de registrar a un objeto Teachers.
   * 
   * @param teach object Teachers.
   * @return object Teachers.
   */
  @ApiOperation(value = "Crea a un profesor")
  @PostMapping(value = "/api/2.0/teachers", consumes = "application/json", 
      produces = "application/json")
  public ResponseEntity<Teacher> createTeachers(@RequestBody Teacher teach) {

    return new ResponseEntity<Teacher>(service.create(teach), HttpStatus.CREATED);
  }

  /**
   * La función updateTeachers() se encarga de actualizar a un objeto Teachers.
   * 
   * @param teach object Teachers.
   * @return object Teachers.
   */
  @ApiOperation(value = "Actualiza un profesor")
  @PutMapping(value = "/api/2.0/teachers", consumes = "application/json", 
        produces = "application/json")
  public ResponseEntity<Teacher> updateTeachers(@RequestBody Teacher teach) {
    String mensaje = "";
    Optional<Teacher> tea = service.findByID(teach.getTeacherId());

    if (tea.isPresent()) {
      return new ResponseEntity<Teacher>(service.update(teach), HttpStatus.OK);
    } else {
      mensaje = "error " + teach.getTeacherId();
      throw new ModeloNotFoundException(mensaje);
    }
  }

  /**
   * La función deleteTeachers() se encarga de remover a un objeto teachers por su
   * código.
   * 
   * @param teach Update.
   * @return object families delete.
   */
  @ApiOperation(value = "Elimina datos de un profesor")
  @DeleteMapping(value = "/api/2.0/teachers", consumes = "application/json", 
          produces = "application/json")
  public ResponseEntity<Integer> deleteTeachers(@RequestBody Teacher teach) {
    int rp = 0;
    String mensaje = "";

    Optional<Teacher> fa = service.findByID(teach.getTeacherId());

    if (fa.isPresent()) {
      log.info("id " + teach.getTeacherId());
      rp = service.delete(teach.getTeacherId());
      return new ResponseEntity<Integer>(rp, HttpStatus.OK);
    } else {
      mensaje = "error ID " + teach.getTeacherId();
      throw new ModeloNotFoundException(mensaje);
    }
  }

  /**
   * La función listById() se le envia un parametro id y retorna a la Teachers de
   * ese id.
   * 
   * @param id parametro de filtro.
   * @return Teacher.
   */
  @ApiOperation(value = "Retorna inforacion de profesor  por su Id")
  @GetMapping(value = "/api/2.0/teachers/{id}")
  public ResponseEntity<Object> listById(@PathVariable("id") Integer id) {

    String mensaje = "";
    Optional<Teacher> teach = service.findByID(id);

    if (teach.isPresent()) {
      return new ResponseEntity<Object>(teach, HttpStatus.OK);
    } else {
      mensaje = "error  " + id;
      throw new ModeloNotFoundException(mensaje);
    }
  }

}
