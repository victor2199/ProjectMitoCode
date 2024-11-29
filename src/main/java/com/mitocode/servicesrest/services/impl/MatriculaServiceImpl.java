package com.mitocode.servicesrest.services.impl;

import com.mitocode.servicesrest.model.DetalleMatricula;
import com.mitocode.servicesrest.model.Matricula;
import com.mitocode.servicesrest.repo.IDetalleMatriculaRepo;
import com.mitocode.servicesrest.repo.IGenericRepo;
import com.mitocode.servicesrest.repo.IMatriculaRepo;
import com.mitocode.servicesrest.services.IDetalleMatriculaService;
import com.mitocode.servicesrest.services.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatriculaServiceImpl extends CrudImpl<Matricula, Integer> implements IMatriculaService {

    private final IMatriculaRepo repo;

    @Override
    protected IGenericRepo<Matricula, Integer> getRepo() {
        return repo;
    }
}
