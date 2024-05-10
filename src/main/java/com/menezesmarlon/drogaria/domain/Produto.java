package com.menezesmarlon.drogaria.domain;


import java.math.BigDecimal;
import java.time.LocalDate;

public class Produto {
    // Os atributos de uma classe correspondem às colunas de uma tabela, AVALIE BEM!
    private Short codigo;
    private String nome;
    private Byte quantidade;
    private BigDecimal preCo;
    private LocalDate validade;
}
