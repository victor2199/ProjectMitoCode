package com.mitocode.servicesrest.controller;

import com.mitocode.servicesrest.dto.CursoDTO;
import com.mitocode.servicesrest.model.Curso;
import com.mitocode.servicesrest.services.ICursoService;
import com.mitocode.servicesrest.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
@RequiredArgsConstructor
public class CursoController {

    private final ICursoService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity <List<CursoDTO>> findAll() throws Exception {

        List<CursoDTO> list = mapperUtil.mapList(service.findAll(), CursoDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity <CursoDTO> findById(@PathVariable("id")  Integer id) throws Exception {

        Curso obj = service.findById(id);

        return ResponseEntity.ok(mapperUtil.map(obj, CursoDTO.class));
    }

    @PostMapping
    public ResponseEntity <CursoDTO> save(@Valid @RequestBody CursoDTO dto) throws Exception {

        Curso obj = service.save(mapperUtil.map(dto, Curso.class));

        return new ResponseEntity<>(mapperUtil.map(obj, CursoDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity <CursoDTO> update(@PathVariable("id") Integer id,@Valid @RequestBody CursoDTO dto) throws Exception {

        Curso obj = service.update(id, mapperUtil.map(dto, Curso.class));

        return new ResponseEntity<>(mapperUtil.map(obj, CursoDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable("id") Integer id) throws Exception {

        service.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
