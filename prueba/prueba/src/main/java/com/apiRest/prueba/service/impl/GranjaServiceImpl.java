package com.apiRest.prueba.service.impl;

import com.apiRest.prueba.dto.GranjaDto;
import com.apiRest.prueba.entity.GranjaEntity;
import com.apiRest.prueba.entity.GranjeroEntity;
import com.apiRest.prueba.mapper.GranjaMapper;
import com.apiRest.prueba.repository.GranjaRepository;
import com.apiRest.prueba.service.GranjaService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GranjaServiceImpl implements GranjaService {

    @Autowired
    public GranjaRepository granjaRepository;

    @Autowired
    public GranjaMapper granjaMapper;

    @Override
    public GranjaDto crearGranja(GranjaDto granjaDto) {
        GranjaEntity granja = granjaRepository.save(granjaMapper.toMapGranja(granjaDto));
        return granjaMapper.toMapGranjaDto(granja);
    }

    @Override
    public GranjaDto obtenerGranja(Integer id) {
        GranjaEntity granja = granjaRepository.findById(id).orElseThrow(()->new ResolutionException("No se encontro granja"));
        return granjaMapper.toMapGranjaDto(granja);
    }

    @Override
    public List<GranjaDto> listaGranjas() {
        List<GranjaEntity> granja = granjaRepository.findAll();
        return granja.stream().map((granjas)-> granjaMapper.toMapGranjaDto(granjas)).collect(Collectors.toList());
    }

    @Override
    public GranjaDto actualizarGranja(Integer id, GranjaDto granjaDto) {

        GranjaEntity granja = granjaRepository.findById(id).orElseThrow(()->new ResolutionException("No se encontro granja"));

        granja.setNombre(granjaDto.getNombre());
        granja.setPresupuesto(granjaDto.getPresupuesto());

        granjaRepository.save(granja);

        return granjaMapper.toMapGranjaDto(granja);
    }

    @Override
    public void eliminarGranja(Integer id) {
        GranjaEntity granja = granjaRepository.findById(id).orElseThrow(()->new ResolutionException("No se encontro granja"));
        granjaRepository.deleteById(id);
    }
}
