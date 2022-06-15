package com.athena.pessoa.service;


import com.athena.pessoa.domain.entity.Pessoa;
import com.athena.pessoa.repository.PessoaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.athena.pessoa.utils.ScenarioFactory.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;


    @Test
    void testWhenPessoaSavedSucess() {
        Pessoa pessoa = createFakeEntity();
        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);
        Pessoa sucessMessage = pessoaService.savePessoa(pessoa);
        assertEquals(pessoa, sucessMessage);
    }

    @Test
    void testWhenPessoaSavedException() {
        Pessoa pessoa = createFakeEntity();
        when(pessoaRepository.save(pessoa)).thenThrow(RuntimeException.class);
        Assertions.assertThrows(RuntimeException.class, () -> {
            pessoaService.savePessoa(pessoa);
        });
    }
}