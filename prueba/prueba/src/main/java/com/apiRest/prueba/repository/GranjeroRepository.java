package com.apiRest.prueba.repository;

import com.apiRest.prueba.entity.GranjeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GranjeroRepository extends JpaRepository<GranjeroEntity, Integer> {
}
