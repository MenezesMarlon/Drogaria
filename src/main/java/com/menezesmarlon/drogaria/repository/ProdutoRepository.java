package com.menezesmarlon.drogaria.repository;

import com.menezesmarlon.drogaria.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Short>{

}
