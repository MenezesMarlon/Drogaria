package com.menezesmarlon.drogaria_api.repository;

import com.menezesmarlon.drogaria_api.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Short>{

}
