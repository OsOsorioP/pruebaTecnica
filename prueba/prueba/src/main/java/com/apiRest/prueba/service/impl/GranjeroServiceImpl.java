package com.apiRest.prueba.service.impl;

import com.apiRest.prueba.dto.GranjaDto;
import com.apiRest.prueba.dto.GranjeroDto;
import com.apiRest.prueba.entity.GranjaEntity;
import com.apiRest.prueba.entity.GranjeroEntity;
import com.apiRest.prueba.mapper.GranjaMapper;
import com.apiRest.prueba.mapper.GranjeroMapper;
import com.apiRest.prueba.repository.GranjaRepository;
import com.apiRest.prueba.repository.GranjeroRepository;
import com.apiRest.prueba.service.GranjeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GranjeroServiceImpl implements GranjeroService {

    @Autowired
    public GranjeroRepository granjeroRepository;

    @Autowired
    public GranjeroMapper granjeroMapper;

    @Autowired
    public GranjaRepository granjaRepository;

    @Override
    public GranjeroDto crearGranjero(GranjeroDto granjeroDto) {

        GranjeroEntity granjero = granjeroRepository.save(granjeroMapper.toMapGranjero(granjeroDto));

        return granjeroMapper.toMapGranjeroDto(granjero);
    }

    @Override
    public GranjeroDto obtenerGranjero(Integer id) {
        GranjeroEntity granjero = granjeroRepository.findById(id).orElseThrow(()->new ResolutionException("No se encontro granjero"));
        return granjeroMapper.toMapGranjeroDto(granjero);
    }

    @Override
    public List<GranjeroDto> listaGranjero() {
        List<GranjeroEntity> granja = granjeroRepository.findAll();
        return granja.stream().map((granjas)-> granjeroMapper.toMapGranjeroDto(granjas)).collect(Collectors.toList());
    }

    @Override
    public GranjeroDto actualizarGranjero(Integer id, GranjeroDto granjeroDto) {
        GranjeroEntity granjero = granjeroMapper.toMapGranjero(granjeroDto);

        granjero.setNombre(granjeroDto.getNombre());

        granjeroRepository.save(granjero);

        return granjeroMapper.toMapGranjeroDto(granjero);
    }

    @Override
    public void eliminarGranjero(Integer id) {
        GranjeroEntity granjero = granjeroRepository.findById(id).orElseThrow(()->new ResolutionException("No se encontro granjero"));
        granjeroRepository.deleteById(id);
    }
}
