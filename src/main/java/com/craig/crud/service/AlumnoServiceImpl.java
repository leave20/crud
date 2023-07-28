package com.craig.crud.service;

import com.craig.crud.model.Alumno;
import com.craig.crud.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements IAlumnoService{

    private final AlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public List<Alumno> listar() {
        return (List<Alumno>) alumnoRepository.findAll();
    }

    @Override
    public Alumno listarPorId(int id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(int id) {
        alumnoRepository.deleteById(id);
    }

    @Override
    public Alumno modificar(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno guardar(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }
}
