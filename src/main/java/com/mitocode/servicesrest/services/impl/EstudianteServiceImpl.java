package com.mitocode.servicesrest.services.impl;

import com.mitocode.servicesrest.model.Estudiante;
import com.mitocode.servicesrest.repo.IEstudianteRepo;
import com.mitocode.servicesrest.repo.IGenericRepo;
import com.mitocode.servicesrest.services.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl extends CrudImpl<Estudiante, Integer> implements IEstudianteService {

    private final IEstudianteRepo repo;

    @Override
    protected IGenericRepo<Estudiante, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Estudiante> findAllByOrderByEdadDesc() {
        return repo.findAllByOrderByEdadDesc();
    }
}
