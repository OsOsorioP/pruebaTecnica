package com.apiRest.prueba.dto;

import com.apiRest.prueba.entity.GranjaEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GranjeroDto {
    private Integer id;
    private String nombre;
    private GranjaEntity granja;
}
