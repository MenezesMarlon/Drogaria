package com.menezesmarlon.drogaria.service;

import com.menezesmarlon.drogaria.domain.Categoria;
import com.menezesmarlon.drogaria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscarPorCodigo(Integer codigo) {
        Optional<Categoria> resultado = categoriaRepository.findById(codigo);
        if (resultado.isEmpty()) {
            throw new RuntimeException("Categoria não encontrada");
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

    public Categoria remover(Integer codigo) {
        Categoria categoria = categoriaRepository.findById(codigo).get();
        categoriaRepository.delete(categoria);
        return categoria;
    }

    public Categoria editar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

}
