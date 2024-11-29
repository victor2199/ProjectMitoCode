package com.mitocode.servicesrest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DetalleMatricula   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idDetalleMatricula;

    @ManyToOne
    @JoinColumn(name = "idCurso", nullable = false, foreignKey = @ForeignKey(name = "FK_DETALLEMATRICULA_CURSO"))
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_matricula", nullable = false, foreignKey = @ForeignKey(name = "FK_DETALLEMATRICULA_MATRICULA"))
    private Matricula matricula;

    @Column(nullable = false, length = 200)
    private String aula;
}
