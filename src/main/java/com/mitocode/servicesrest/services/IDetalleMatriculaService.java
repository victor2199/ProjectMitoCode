package com.mitocode.servicesrest.services;

import com.mitocode.servicesrest.model.DetalleMatricula;
import com.mitocode.servicesrest.model.Estudiante;

import java.util.List;
import java.util.Map;

public interface IDetalleMatriculaService extends ICrud<DetalleMatricula, Integer>{

    Map<String, List<String>> getMostrarEstudiantesCurso();

}
