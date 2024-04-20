package br.com.mundodoestudante.apigratificacao.repository;

import br.com.mundodoestudante.apigratificacao.model.Loja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LojaRepository extends JpaRepository<Loja, Long> {
}
