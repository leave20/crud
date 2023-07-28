package com.craig.crud.controller;

import com.craig.crud.model.Alumno;
import com.craig.crud.service.AlumnoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class AlumnoController {

    private final AlumnoServiceImpl alumnoService;

    @Autowired
    public AlumnoController(AlumnoServiceImpl alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<Iterable<Alumno>> listar(){
        return ResponseEntity.ok(alumnoService.listar());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Alumno> listarPorId(@PathVariable int id){
        return ResponseEntity.ok(alumnoService.listarPorId(id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<Alumno> guardar(@RequestBody Alumno alumno){
        return ResponseEntity.ok(alumnoService.guardar(alumno));
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<Alumno> modificar(@PathVariable int id,  @RequestBody Alumno alumno){
        alumno.setId(id);
        return ResponseEntity.ok(alumnoService.modificar(alumno));
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id){
        alumnoService.eliminar(id);
    }
}
