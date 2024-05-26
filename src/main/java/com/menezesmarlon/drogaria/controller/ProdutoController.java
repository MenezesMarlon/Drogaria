package com.menezesmarlon.drogaria.controller;

import com.menezesmarlon.drogaria.domain.Produto;
import com.menezesmarlon.drogaria.exception.ResourceNotFoundException;
import com.menezesmarlon.drogaria.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        try {
            Produto produto = produtoService.buscaPorCodigo(codigo);
            return produto;
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado", e);
        }

    }

    @PostMapping
    public Produto inserir(@RequestBody Produto produto){
        Produto produtoSalvo = produtoService.inserir(produto);
        return produtoSalvo;
    }

    @DeleteMapping("/{codigo}")
    public Produto remover(@PathVariable Short codigo){
        return produtoService.remover(codigo);
    }

    @PutMapping
    public Produto editar(@RequestBody Produto produto){
        return produtoService.editar(produto);
    }

}
