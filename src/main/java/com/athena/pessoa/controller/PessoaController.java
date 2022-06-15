package com.athena.pessoa.controller;

import com.athena.pessoa.domain.entity.Pessoa;
import com.athena.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa createPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.savePessoa(pessoa);
    }

    @GetMapping
    public List<Pessoa> getPessoaList(){
        return pessoaService.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable("id") Long id) throws Exception {
        return  ResponseEntity.ok(pessoaService.findById(id).orElseThrow(() -> new NoSuchElementException("Pessoa não encontrada!")));

    }

    @PutMapping
    public ResponseEntity<Pessoa> updateById(@RequestBody Pessoa pessoa) {
        try {
            return ResponseEntity.ok(pessoaService.updatePessoa(pessoa));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pessoa> deleteById(@PathVariable long id) {
        try {
            pessoaService.deletePessoa(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/imc/{id}")
    public Double calculaIMC(@PathVariable("id") Long id) throws Exception {
        return  pessoaService.calculaIMC(id);
    }
}
