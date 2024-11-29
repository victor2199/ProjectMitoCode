package com.mitocode.servicesrest.controller;

import com.mitocode.servicesrest.dto.DetalleMatriculaDTO;
import com.mitocode.servicesrest.model.DetalleMatricula;
import com.mitocode.servicesrest.services.IDetalleMatriculaService;
import com.mitocode.servicesrest.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/detalleMatricula")
@RequiredArgsConstructor
public class DetalleMatriculaController {

    private final IDetalleMatriculaService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity <List<DetalleMatriculaDTO>> findAll() throws Exception {

        List<DetalleMatriculaDTO> list = mapperUtil.mapList(service.findAll(), DetalleMatriculaDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity <DetalleMatriculaDTO> findById(@PathVariable("id")  Integer id) throws Exception {

        DetalleMatricula obj = service.findById(id);

        return ResponseEntity.ok(mapperUtil.map(obj, DetalleMatriculaDTO.class));
    }

    @PostMapping
    public ResponseEntity <DetalleMatriculaDTO> save(@Valid @RequestBody DetalleMatriculaDTO dto) throws Exception {

        DetalleMatricula obj = service.save(mapperUtil.map(dto, DetalleMatricula.class));

        return new ResponseEntity<>(mapperUtil.map(obj, DetalleMatriculaDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity <DetalleMatriculaDTO> update(@PathVariable("id") Integer id,@Valid @RequestBody DetalleMatriculaDTO dto) throws Exception {

        DetalleMatricula obj = service.update(id, mapperUtil.map(dto, DetalleMatricula.class));

        return new ResponseEntity<>(mapperUtil.map(obj, DetalleMatriculaDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable("id") Integer id) throws Exception {

        service.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/list/CursoxEstudiante")
    public ResponseEntity <Map<String, List<String>>> getMostrarEstudiantesCurso (){
        Map<String, List<String>> map = service.getMostrarEstudiantesCurso();

        return ResponseEntity.ok(map);
    }
}
