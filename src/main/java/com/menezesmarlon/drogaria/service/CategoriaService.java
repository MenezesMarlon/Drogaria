package com.menezesmarlon.drogaria.service;

import com.menezesmarlon.drogaria.domain.Categoria;
import com.menezesmarlon.drogaria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscarPorCodigo(Integer codigo){
        Optional<Categoria> resultado = categoriaRepository.findById(codigo);
        if (resultado.isEmpty()){
            throw new RuntimeException("Categoria não encontrada");
        }
        Categoria categoria = resultado.get();
        return categoria;
    }
}
