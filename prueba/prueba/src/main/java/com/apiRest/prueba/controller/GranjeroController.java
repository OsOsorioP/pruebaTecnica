package com.apiRest.prueba.controller;

import com.apiRest.prueba.dto.GranjaDto;
import com.apiRest.prueba.dto.GranjeroDto;
import com.apiRest.prueba.entity.GranjeroEntity;
import com.apiRest.prueba.service.impl.GranjeroServiceImpl;
import jdk.jshell.Snippet;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/granjero")
public class GranjeroController {

    @Autowired
    public GranjeroServiceImpl granjeroService;

    @GetMapping("/{id}")
    public ResponseEntity<GranjeroDto> obtenerGranjero(@PathVariable("id") Integer id){
        GranjeroDto granjero = granjeroService.obtenerGranjero(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(granjero);
    }

    @GetMapping("/")
    public ResponseEntity<List<GranjeroDto>> listaGranjeros(){
        List<GranjeroDto> granjero = granjeroService.listaGranjero();
        return ResponseEntity.status(HttpStatus.OK).body(granjero);
    }

    @PostMapping("/")
    public ResponseEntity<GranjeroDto> crearGranja(@RequestBody GranjeroDto granjeroDto){
        GranjeroDto granjero = granjeroService.crearGranjero(granjeroDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(granjero);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GranjeroDto> actualizarGranjero(@PathVariable("id") Integer id, @RequestBody GranjeroDto granjeroDto){
        GranjeroDto granjero = granjeroService.actualizarGranjero(id,granjeroDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(granjero);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarGranjero(@PathVariable("id") Integer id){
        granjeroService.eliminarGranjero(id);
        return ResponseEntity.status(HttpStatus.OK).body("Granjero eliminado");
    }


}
