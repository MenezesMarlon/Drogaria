package com.menezesmarlon.drogaria.controller;

import com.menezesmarlon.drogaria.domain.Categoria;
import com.menezesmarlon.drogaria.exception.ResourceNotFindException;
import com.menezesmarlon.drogaria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listar() {
        List<Categoria> categorias = categoriaService.listar();
        return categorias;
    }
    @GetMapping("/{codigo}")
    public Categoria buscaPorCodigo(@PathVariable Integer codigo){
        try{
        Categoria categoria = categoriaService.buscarPorCodigo(codigo);
        return categoria;
        } catch (ResourceNotFindException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada", e);
        }
    }
    @PostMapping
    public Categoria inserir(@RequestBody Categoria categoria) {
        Categoria categoriaSalva = categoriaService.inserir(categoria);
        return categoriaSalva;
    }

    @DeleteMapping("/{codigo}")
    public Categoria remover(@PathVariable Integer codigo) {
        Categoria categoria = categoriaService.remover(codigo);
        return categoria;
    }

    @PutMapping
    public Categoria editar(@RequestBody Categoria categoria) {
        return categoriaService.editar(categoria);
    }


}
