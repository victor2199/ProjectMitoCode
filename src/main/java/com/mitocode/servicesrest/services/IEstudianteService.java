package com.mitocode.servicesrest.services;

import com.mitocode.servicesrest.model.Estudiante;

import java.util.List;

public interface IEstudianteService extends ICrud<Estudiante, Integer>{

    List<Estudiante> findAllByOrderByEdadDesc();
}
