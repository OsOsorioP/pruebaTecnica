package com.apiRest.prueba.service;

import com.apiRest.prueba.dto.GranjaDto;
import com.apiRest.prueba.dto.GranjeroDto;

import java.util.List;

public interface GranjeroService {

    GranjeroDto crearGranjero(GranjeroDto granjeroDto);

    GranjeroDto obtenerGranjero(Integer id);

    List<GranjeroDto> listaGranjero();

    GranjeroDto actualizarGranjero(Integer id, GranjeroDto granjeroDto);

    void eliminarGranjero(Integer id);
}
