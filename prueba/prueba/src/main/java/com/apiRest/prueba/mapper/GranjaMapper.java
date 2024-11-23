package com.apiRest.prueba.mapper;

import com.apiRest.prueba.dto.GranjaDto;
import com.apiRest.prueba.entity.GranjaEntity;
import org.springframework.stereotype.Component;

@Component
public class GranjaMapper {

    public GranjaDto toMapGranjaDto(GranjaEntity granjaEntity){
        return GranjaDto.builder()
                .id(granjaEntity.getId())
                .nombre(granjaEntity.getNombre())
                .presupuesto(granjaEntity.getPresupuesto())
                .build();
    }

    public GranjaEntity toMapGranja(GranjaDto granjaDto){
        return GranjaEntity.builder()
                .nombre(granjaDto.getNombre())
                .presupuesto(granjaDto.getPresupuesto())
                .build();
    }
}
