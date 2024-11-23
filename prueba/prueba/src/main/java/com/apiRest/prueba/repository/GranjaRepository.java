package com.apiRest.prueba.repository;

import com.apiRest.prueba.entity.GranjaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GranjaRepository extends JpaRepository<GranjaEntity,Integer> {
}
