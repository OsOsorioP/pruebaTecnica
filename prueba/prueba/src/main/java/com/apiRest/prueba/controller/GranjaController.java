package com.apiRest.prueba.controller;

import com.apiRest.prueba.dto.GranjaDto;
import com.apiRest.prueba.entity.GranjaEntity;
import com.apiRest.prueba.service.impl.GranjaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/granja")
public class GranjaController {
    @Autowired
    public GranjaServiceImpl granjaService;

    @GetMapping("/{id}")
    public ResponseEntity<GranjaDto> obtenerGranja(@PathVariable("id") Integer id){
        GranjaDto granja = granjaService.obtenerGranja(id);
        return ResponseEntity.status(HttpStatus.OK).body(granja);
    }

    @GetMapping("/")
    public ResponseEntity<List<GranjaDto>> listaGranjas(){
        List<GranjaDto> granja = granjaService.listaGranjas();
        return ResponseEntity.status(HttpStatus.OK).body(granja);
    }

    @PostMapping("/")
    public ResponseEntity<GranjaDto> crearGranja(@RequestBody GranjaDto granjaDto){
        GranjaDto granja = granjaService.crearGranja(granjaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(granja);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GranjaDto> actualizarGranja(@PathVariable("id") Integer id, @RequestBody GranjaDto granjaDto){
        GranjaDto granja = granjaService.actualizarGranja(id,granjaDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(granja);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarGranja(@PathVariable("id") Integer id){
        granjaService.eliminarGranja(id);
        return ResponseEntity.status(HttpStatus.OK).body("Granja eliminado");
    }
}
