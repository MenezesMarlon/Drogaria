package com.menezesmarlon.drogaria.controller;

import com.menezesmarlon.drogaria.domain.Categoria;
import com.menezesmarlon.drogaria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> listar() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias;
    }
    @PostMapping
    public Categoria inserir(@RequestBody Categoria categoria){
        Categoria categoriaSalva = categoriaRepository.save(categoria);
        return categoriaSalva;
    }

}
