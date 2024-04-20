package br.com.mundodoestudante.apigratificacao.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lojas")
@Getter
@EqualsAndHashCode(of = "id")
public class Loja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    @OneToMany
    private List<Atendente> atendentes = new ArrayList<>();

    public Loja() {
    }

    public Loja(String nome) {
        this.nome = nome;
    }

    public void atribuirAtendente(Atendente atendente) {
        this.atendentes.add(atendente);
    }

}
