package com.mitocode.servicesrest.repo;

import com.mitocode.servicesrest.model.Estudiante;

import java.util.List;

public interface IEstudianteRepo extends IGenericRepo<Estudiante, Integer> {

    List<Estudiante> findAllByOrderByEdadDesc();
}
