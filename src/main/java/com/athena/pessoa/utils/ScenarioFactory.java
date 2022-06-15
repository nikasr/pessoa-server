package com.athena.pessoa.utils;

import com.athena.pessoa.domain.entity.Pessoa;

import java.time.LocalDate;

public class ScenarioFactory {

    private static final String PESSOA_NOME = "Maria";
    private static final String PESSOA_CPF = "369.333.878-79";
    private static final long PESSOA_ID = 1L;
    private static final char PESSOA_SEXO = 'F';
    private static final Double PESSOA_PESO = 1.65;
    private static final Double PESSOA_ALTURA = 63.0;
    public static final LocalDate PESSOA_DATA_NASC = LocalDate.of(2010, 10, 1);

    public static Pessoa createFakeEntity() {
        return Pessoa.builder()
                .id(PESSOA_ID)
                .nome(PESSOA_NOME)
                .cpf(PESSOA_CPF)
                .data_nasc(PESSOA_DATA_NASC)
                .sexo(PESSOA_SEXO)
                .peso(PESSOA_PESO)
                .altura(PESSOA_ALTURA)
                .build();
    }
}
