package com.menezesmarlon.drogaria.controller;

import com.menezesmarlon.drogaria.domain.Produto;
import com.menezesmarlon.drogaria.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listar() {
        List<Produto> produtos = produtoService.listar();
        return produtos;
    }

    @GetMapping("/{codigo}")
    public Produto buscaPorCodigo(@PathVariable Short codigo) {
        Produto produto = produtoService.buscaPorCodigo(codigo);
        return produto;
    }

}
