package com.menezesmarlon.drogaria.repository;

import com.menezesmarlon.drogaria.domain.Produto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest
public class ProdutoRepositoryTests {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Test
    public void inserir() {
        Produto p1 = new Produto(
                null,
                "coca cola",
                Byte.valueOf("15"),
                BigDecimal.valueOf(10.50),
                LocalDate.of(2024, 12, 30));

        Produto p2 = new Produto(
                null,
                "Sprite",
                Byte.valueOf("23"),
                BigDecimal.valueOf(8.00),
                LocalDate.of(2024, 11, 25));

        produtoRepository.save(p1);
        produtoRepository.save(p2);
    }
}
