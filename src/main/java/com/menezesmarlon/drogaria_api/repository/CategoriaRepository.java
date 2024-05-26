package com.menezesmarlon.drogaria_api.repository;

import com.menezesmarlon.drogaria_api.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Short> {

}
