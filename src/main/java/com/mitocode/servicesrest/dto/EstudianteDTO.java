package com.mitocode.servicesrest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstudianteDTO {

    private Integer idEstudiante;

    @NotNull
    private String nombreEstudiante;

    @NotNull
    private String apellidoEstudiante;

    @NotNull
    private Integer dniEstudiante;

    @NotNull
    @Max(value = 100)
    @Min(value = 1)
    private Integer edadEstudiante;
}
