package com.apiRest.prueba.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GranjaDto {

    private Integer id;
    private String nombre;
    private Integer presupuesto;
}
