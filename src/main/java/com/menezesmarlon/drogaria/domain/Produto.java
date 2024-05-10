package com.menezesmarlon.drogaria.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    // Os atributos de uma classe correspondem às colunas de uma tabela, AVALIE BEM!
    private Short codigo;
    private String nome;
    private Byte quantidade;
    private BigDecimal preco;
    private LocalDate dataValidade;
}
