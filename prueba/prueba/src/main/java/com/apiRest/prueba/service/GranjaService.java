package com.apiRest.prueba.service;

import com.apiRest.prueba.dto.GranjaDto;

import java.util.List;

public interface GranjaService {

    GranjaDto crearGranja(GranjaDto granjaDto);

    GranjaDto obtenerGranja(Integer id);

    List<GranjaDto> listaGranjas();

    GranjaDto actualizarGranja(Integer id, GranjaDto granjaDto);

    void eliminarGranja(Integer id);
}
