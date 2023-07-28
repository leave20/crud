package com.craig.crud.service;

import com.craig.crud.model.Alumno;
import com.craig.crud.repository.AlumnoRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AlumnoServiceImplTest {

    @Mock
    private AlumnoRepository alumnoRepository;

    @InjectMocks
    private AlumnoServiceImpl alumnoService;


    @Test
    void listarTest() {
        // Arrange
        Alumno alumno1 = new Alumno();
        alumno1.setId(1);
        alumno1.setNombre("Test1");

        Alumno alumno2 = new Alumno();
        alumno2.setId(2);
        alumno2.setNombre("Test2");

        List<Alumno> alumnos = Arrays.asList(alumno1, alumno2);

        when(alumnoRepository.findAll()).thenReturn(alumnos);

        // Act
        List<Alumno> result = alumnoService.listar();

        // Assert
        assertEquals(2, result.size());
        assertEquals(alumno1, result.get(0));
        assertEquals(alumno2, result.get(1));
    }

    @Test
    void listarPorIdTest(){
        // Arrange
        Alumno alumno1 = new Alumno();
        alumno1.setId(1);
        alumno1.setNombre("Test1");

        when(alumnoRepository.findById(1)).thenReturn(java.util.Optional.of(alumno1));

        // Act
        Alumno result = alumnoService.listarPorId(1);

        // Assert
        assertEquals(alumno1, result);
    }
}