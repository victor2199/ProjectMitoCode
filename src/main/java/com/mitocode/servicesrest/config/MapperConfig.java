package com.mitocode.servicesrest.config;

import com.mitocode.servicesrest.dto.EstudianteDTO;
import com.mitocode.servicesrest.dto.MatriculaDTO;
import com.mitocode.servicesrest.model.Estudiante;
import com.mitocode.servicesrest.model.Matricula;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("defaultMapper")
    public ModelMapper defaultMapper() {
        return new ModelMapper();
    }

    @Bean("estudianteMapper")
    public ModelMapper estudianteMapper() {

        ModelMapper mapper = new ModelMapper();

        mapper.createTypeMap(Estudiante.class, EstudianteDTO.class)
                .addMapping(Estudiante::getNombre, ((dest, v) -> dest.setNombreEstudiante((String) v)));

        mapper.createTypeMap(EstudianteDTO.class, Estudiante.class)
                .addMapping(EstudianteDTO::getNombreEstudiante, (dest, v) -> dest.setNombre((String) v));

        return mapper;
    }

    @Bean("matriculaMapper")
    public ModelMapper matriculaMapper() {

        ModelMapper mapper = new ModelMapper();

        mapper.createTypeMap(Matricula.class, MatriculaDTO.class)
                .addMapping(Matricula::getIdMatricula, ((dest, v) -> dest.setIdMatricula((Integer) v)));

        mapper.createTypeMap(MatriculaDTO.class, Matricula.class)
                .addMapping(MatriculaDTO::getIdMatricula, (dest, v) -> dest.setIdMatricula((Integer) v));

        return mapper;
    }

}
