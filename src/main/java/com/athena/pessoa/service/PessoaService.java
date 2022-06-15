package com.athena.pessoa.service;

import com.athena.pessoa.domain.entity.Pessoa;
import com.athena.pessoa.exception.PessoaNotFoundException;
import com.athena.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa savePessoa(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> findAll() {
        return   pessoaRepository.findAll();
    }

    public Optional<Pessoa> findById(Long id) {
        return pessoaRepository.findById(id);
    }

    public Pessoa updatePessoa(Pessoa pessoa) throws PessoaNotFoundException {
        Pessoa pessoaOK = verifyIfExists(pessoa.getId());

        if (pessoaOK != null) {
            return pessoaRepository.save(pessoa);
        }else{
            return null;
        }
    }

    public void deletePessoa(Long id) throws PessoaNotFoundException {
        Pessoa pessoaOK = verifyIfExists(id);

        if (pessoaOK != null) {
            pessoaRepository.deleteById(id);
        }
    }

    public double calculaIMC(Long id) throws PessoaNotFoundException{
        Pessoa pessoaOK = verifyIfExists(id);
        var imc = 0.0;

        if (pessoaOK != null) {
            if (pessoaOK.getSexo() == 'M') {
                imc = ((72.7 * pessoaOK.getAltura()) - 58);
            } else {
                imc = ((62.1 * pessoaOK.getAltura()) - 58);
            }
        }

        return imc;
    }

    private Pessoa verifyIfExists(Long id) throws PessoaNotFoundException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));
    }
}
