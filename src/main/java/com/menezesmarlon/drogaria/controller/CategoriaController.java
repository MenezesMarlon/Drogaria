package com.menezesmarlon.drogaria.controller;

import com.menezesmarlon.drogaria.domain.Categoria;
import com.menezesmarlon.drogaria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> listar() {
        List<Categoria> categorias = categoriaRepository.findAll(Sort.by(Sort.Direction.ASC, "codigo"));
        return categorias;
    }

    @GetMapping("/{codigo}")
    public Categoria buscaPorCodigo(@PathVariable Integer codigo) {
        return categoriaRepository.findById(codigo).get();
    }


    @PostMapping
    public Categoria inserir(@RequestBody Categoria categoria) {
        Categoria categoriaSalva = categoriaRepository.save(categoria);
        return categoriaSalva;
    }

    @DeleteMapping("/{codigo}")
    public Categoria remover(@PathVariable Integer codigo) {
        Categoria categoria = categoriaRepository.findById(codigo).get();
        categoriaRepository.delete(categoria);
        return categoria;
    }

    @PutMapping
    public Categoria editar(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }


}
