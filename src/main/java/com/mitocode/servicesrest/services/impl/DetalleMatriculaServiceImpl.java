package com.mitocode.servicesrest.services.impl;

import com.mitocode.servicesrest.model.Curso;
import com.mitocode.servicesrest.model.DetalleMatricula;
import com.mitocode.servicesrest.model.Estudiante;
import com.mitocode.servicesrest.repo.ICursoRepo;
import com.mitocode.servicesrest.repo.IDetalleMatriculaRepo;
import com.mitocode.servicesrest.repo.IGenericRepo;
import com.mitocode.servicesrest.services.ICursoService;
import com.mitocode.servicesrest.services.IDetalleMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class DetalleMatriculaServiceImpl extends CrudImpl<DetalleMatricula, Integer> implements IDetalleMatriculaService {

    private final IDetalleMatriculaRepo repo;

    @Override
    protected IGenericRepo<DetalleMatricula, Integer> getRepo() {
        return repo;
    }


    @Override
    public Map<String, List<String>> getMostrarEstudiantesCurso() {
        Stream<DetalleMatricula> detalleMatriculaStream = repo.findAll().stream();

        Map<String, List<String>> estudiantesPorCurso = detalleMatriculaStream
                .collect(Collectors.groupingBy(
                        detalleMatricula -> detalleMatricula.getCurso().getNombreCurso(),
                        Collectors.mapping(detalleMatricula ->
                                detalleMatricula.getMatricula().getEstudiante().getNombre() +" "+ detalleMatricula.getMatricula().getEstudiante().getApellido(),
                                Collectors.toList())
                ));

        return estudiantesPorCurso.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue, () -> new LinkedHashMap<String, List<String>>()
            ));

    }


}
