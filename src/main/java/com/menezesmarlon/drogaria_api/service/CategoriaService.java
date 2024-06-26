package com.menezesmarlon.drogaria_api.service;

import com.menezesmarlon.drogaria_api.domain.Categoria;
import com.menezesmarlon.drogaria_api.exception.ResourceNotFoundException;
import com.menezesmarlon.drogaria_api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscarPorCodigo(Short codigo) {
        Optional<Categoria> resultado = categoriaRepository.findById(codigo);
        if (resultado.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        Categoria categoria = resultado.get();
        return categoria;
    }

    public List<Categoria> listar() {
        List<Categoria> categorias = categoriaRepository.findAll(Sort.by(Sort.Direction.ASC, "codigo"));
        return categorias;
    }

    public Categoria inserir(Categoria categoria) {
        Categoria categoriaSalva = categoriaRepository.save(categoria);
        return categoriaSalva;
    }

    public Categoria remover(Short codigo) {
        Categoria categoria = categoriaRepository.findById(codigo).get();
        categoriaRepository.delete(categoria);
        return categoria;
    }

    public Categoria editar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

}
