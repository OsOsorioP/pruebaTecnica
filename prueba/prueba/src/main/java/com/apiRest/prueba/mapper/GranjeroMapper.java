package com.apiRest.prueba.mapper;

import com.apiRest.prueba.dto.GranjeroDto;
import com.apiRest.prueba.entity.GranjeroEntity;
import org.springframework.stereotype.Component;

@Component
public class GranjeroMapper {

    public GranjeroDto toMapGranjeroDto(GranjeroEntity granjeroEntity){
        return GranjeroDto.builder()
                .id(granjeroEntity.getId())
                .nombre(granjeroEntity.getNombre())
                .granja(granjeroEntity.getGranja())
                .build();
    }

    public GranjeroEntity toMapGranjero(GranjeroDto granjeroDto){
        return GranjeroEntity.builder()
                .id(granjeroDto.getId())
                .nombre(granjeroDto.getNombre())
                .granja(granjeroDto.getGranja())
                .build();
    }

}
