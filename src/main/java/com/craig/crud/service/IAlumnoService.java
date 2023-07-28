package com.craig.crud.service;

import com.craig.crud.model.Alumno;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IAlumnoService {

    //listar
    List<Alumno> listar();

    //listar por id
    Alumno listarPorId(int id);

    //eliminar por id
    void eliminar(int id);

    //modificar por id
    Alumno modificar(Alumno alumno);


    //guardar
    Alumno guardar(Alumno alumno);

}
