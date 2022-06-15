package com.athena.pessoa.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Pessoa {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @OrderBy()
    private String nome;

    private LocalDate data_nasc;

    @Column(nullable = false, unique = true)
    private String cpf;

    private char sexo;

    private Double altura;

    private Double peso;

    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Pessoa pessoa = (Pessoa) o;

        return Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {
        return 1225039686;
    }
}
