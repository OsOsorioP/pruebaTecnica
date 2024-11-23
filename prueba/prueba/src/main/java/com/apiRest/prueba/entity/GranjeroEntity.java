package com.apiRest.prueba.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Fetch;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "granjero")
public class GranjeroEntity {
    @Id
    private Integer id;

    @Column(name = "gra_nombre", nullable = false)
    private String nombre;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "granjas", unique = true)
    private GranjaEntity granja;

}
