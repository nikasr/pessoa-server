package com.athena.pessoa.repository;

import com.athena.pessoa.domain.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

}
