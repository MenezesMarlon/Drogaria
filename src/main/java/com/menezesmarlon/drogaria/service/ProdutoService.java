package com.menezesmarlon.drogaria.service;

import com.menezesmarlon.drogaria.domain.Produto;
import com.menezesmarlon.drogaria.exception.ResourceNotFoundException;
import com.menezesmarlon.drogaria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listar() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos;
    }

    public Produto buscaPorCodigo(Short codigo) {
        Optional<Produto> resultado = produtoRepository.findById(codigo);
        if (resultado.isEmpty()){
            throw new ResourceNotFoundException();
        }
        Produto produto = resultado.get();
        return produto;
    }


}
