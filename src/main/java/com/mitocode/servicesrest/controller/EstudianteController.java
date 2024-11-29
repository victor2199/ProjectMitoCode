package com.mitocode.servicesrest.controller;

import com.mitocode.servicesrest.dto.EstudianteDTO;
import com.mitocode.servicesrest.model.Estudiante;
import com.mitocode.servicesrest.services.IEstudianteService;
import com.mitocode.servicesrest.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {

    private final IEstudianteService service;
    private final MapperUtil mapperUtil;
    @GetMapping
    public ResponseEntity <List<EstudianteDTO>> findAll() throws Exception {

        List<EstudianteDTO> list = mapperUtil.mapList(service.findAll(), EstudianteDTO.class, "estudianteMapper");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity <EstudianteDTO> findById(@PathVariable("id")  Integer id) throws Exception {

        Estudiante obj = service.findById(id);

        return ResponseEntity.ok(mapperUtil.map(obj, EstudianteDTO.class, "estudianteMapper"));
    }

    @PostMapping
    public ResponseEntity <EstudianteDTO> save(@Valid @RequestBody EstudianteDTO dto) throws Exception {

        Estudiante obj = service.save(mapperUtil.map(dto, Estudiante.class, "estudianteMapper"));

        return new ResponseEntity<>(mapperUtil.map(obj, EstudianteDTO.class, "estudianteMapper"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity <EstudianteDTO> update(@PathVariable("id") Integer id,@Valid @RequestBody EstudianteDTO dto) throws Exception {

        Estudiante obj = service.update(id, mapperUtil.map(dto, Estudiante.class, "estudianteMapper"));

        return new ResponseEntity<>(mapperUtil.map(obj, EstudianteDTO.class, "estudianteMapper"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable("id") Integer id) throws Exception {

        service.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/list/edad/desc")
    public ResponseEntity <List<EstudianteDTO>> findAllDesc() throws Exception {
        List<EstudianteDTO> list = mapperUtil.mapList(service.findAllByOrderByEdadDesc(), EstudianteDTO.class, "estudianteMapper");
        return ResponseEntity.ok(list);
    }

}
