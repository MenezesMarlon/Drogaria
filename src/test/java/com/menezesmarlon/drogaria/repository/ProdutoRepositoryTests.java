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
                "Dipirona",
                Byte.valueOf("15"),
                BigDecimal.valueOf(1.50),
                LocalDate.of(2024, 12, 30));

        Produto p2 = new Produto(
                null,
                "Dorflex",
                Byte.valueOf("10"),
                BigDecimal.valueOf(2.50),
                LocalDate.of(2024, 11, 25));

        produtoRepository.save(p1);
        produtoRepository.save(p2);
    }
}
