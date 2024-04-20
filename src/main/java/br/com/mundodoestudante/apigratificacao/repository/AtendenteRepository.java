package br.com.mundodoestudante.apigratificacao.repository;

import br.com.mundodoestudante.apigratificacao.model.Atendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendenteRepository extends JpaRepository<Atendente, Long> {
}
