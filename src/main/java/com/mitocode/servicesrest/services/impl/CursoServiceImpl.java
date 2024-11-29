package com.mitocode.servicesrest.services.impl;

import com.mitocode.servicesrest.model.Curso;
import com.mitocode.servicesrest.model.Estudiante;
import com.mitocode.servicesrest.repo.ICursoRepo;
import com.mitocode.servicesrest.repo.IGenericRepo;
import com.mitocode.servicesrest.services.ICursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl extends CrudImpl<Curso, Integer> implements ICursoService {

    private final ICursoRepo repo;

    @Override
    protected IGenericRepo<Curso, Integer> getRepo() {
        return repo;
    }
}
