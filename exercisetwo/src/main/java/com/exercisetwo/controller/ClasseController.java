package com.exercisetwo.controller;

import com.exercisetwo.exception.ModeloNotFoundException;
import com.exercisetwo.service.IClasseService;
import com.exercisetwo.entity.Classe;

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
public class ClasseController {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private IClasseService service;

  /**
   * La función listClasses() retorna la lista de Classes.
   * 
   * @return list of Classes.
   */
  @ApiOperation(value = "Retorna lista de Classes")
  @GetMapping(value = "/api/2.0/Classes") 
  public ResponseEntity<List<Classe>> listClasses() {
	  return new ResponseEntity<List<Classe>>(service.findAll(),HttpStatus.OK);
  }


  /**
   * La función createClasses() se encarga de registrar a un objeto Classes.
   * 
   * @param teach object Classes.
   * @return object Classes.
   */
  @ApiOperation(value = "Crea a una clase")
  @PostMapping(value = "/api/2.0/Classes", consumes = "application/json", 
      produces = "application/json")
  public ResponseEntity<Classe> createClasses(@RequestBody Classe classe) {

    return new ResponseEntity<Classe>(service.create(classe), HttpStatus.CREATED);
  }

  /**
   * La función updateClasses() se encarga de actualizar a un objeto Classes.
   * 
   * @param teach object Classes.
   * @return object Classes.
   */
  @ApiOperation(value = "Actualiza una clase")
  @PutMapping(value = "/api/2.0/Classes", consumes = "application/json", 
        produces = "application/json")
  public ResponseEntity<Classe> updateClasses(@RequestBody Classe classe) {
    String mensaje = "";
    Optional<Classe> tea = service.findByID(classe.getClasseId());

    if (tea.isPresent()) {
      return new ResponseEntity<Classe>(service.update(classe), HttpStatus.OK);
    } else {
      mensaje = "error " + classe.getClasseId();
      throw new ModeloNotFoundException(mensaje);
    }
  }

  /**
   * La función deleteClasses() se encarga de remover a un objeto Classes por su
   * código.
   * 
   * @param classe Update.
   * @return object families delete.
   */
  @ApiOperation(value = "Elimina datos de una clase")
  @DeleteMapping(value = "/api/2.0/Classes", consumes = "application/json", 
          produces = "application/json")
  public ResponseEntity<Integer> deleteClasses(@RequestBody Classe classe) {
    int rp = 0;
    String mensaje = "";

    Optional<Classe> fa = service.findByID(classe.getClasseId());

    if (fa.isPresent()) {
      log.info("id " + classe.getClasseId());
      rp = service.delete(classe.getClasseId());
      return new ResponseEntity<Integer>(rp, HttpStatus.OK);
    } else {
      mensaje = "error ID " + classe.getClasseId();
      throw new ModeloNotFoundException(mensaje);
    }
  }

  /**
   * La función listById() se le envia un parametro id y retorna a la Classes de
   * ese id.
   * 
   * @param id parametro de filtro.
   * @return Classe.
   */
  @ApiOperation(value = "Retorna inforacion de profesor  por su Id")
  @GetMapping(value = "/api/2.0/Classes/{id}")
  public ResponseEntity<Object> listById(@PathVariable("id") Integer id) {

    String mensaje = "";
    Optional<Classe> classe = service.findByID(id);

    if (classe.isPresent()) {
      return new ResponseEntity<Object>(classe, HttpStatus.OK);
    } else {
      mensaje = "error  " + id;
      throw new ModeloNotFoundException(mensaje);
    }
  }

}
