package com.mitocode.servicesrest.controller;

import com.mitocode.servicesrest.dto.MatriculaDTO;
import com.mitocode.servicesrest.model.Estudiante;
import com.mitocode.servicesrest.model.Matricula;
import com.mitocode.servicesrest.services.IMatriculaService;
import com.mitocode.servicesrest.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matricula")
@RequiredArgsConstructor
public class MatriculaController {

    private final IMatriculaService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity <List<MatriculaDTO>> findAll() throws Exception {

        List<MatriculaDTO> list = mapperUtil.mapList(service.findAll(), MatriculaDTO.class, "matriculaMapper" );
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity <MatriculaDTO> findById(@PathVariable("id")  Integer id) throws Exception {

        Matricula obj = service.findById(id);

        return ResponseEntity.ok(mapperUtil.map(obj, MatriculaDTO.class, "matriculaMapper" ));
    }

    @PostMapping
    public ResponseEntity <MatriculaDTO> save(@Valid @RequestBody MatriculaDTO dto) throws Exception {

        Matricula obj = service.save(mapperUtil.map(dto, Matricula.class));

        return new ResponseEntity<>(mapperUtil.map(obj, MatriculaDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity <MatriculaDTO> update(@PathVariable("id") Integer id,@Valid @RequestBody MatriculaDTO dto) throws Exception {

        Matricula obj = service.update(id, mapperUtil.map(dto, Matricula.class, "matriculaMapper" ));

        return new ResponseEntity<>(mapperUtil.map(obj, MatriculaDTO.class, "matriculaMapper" ), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable("id") Integer id) throws Exception {

        service.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
