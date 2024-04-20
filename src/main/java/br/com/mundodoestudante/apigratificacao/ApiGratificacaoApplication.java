package br.com.mundodoestudante.apigratificacao;

import br.com.mundodoestudante.apigratificacao.repository.AtendenteRepository;
import br.com.mundodoestudante.apigratificacao.repository.LojaRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGratificacaoApplication implements CommandLineRunner {

	@Autowired
	private AtendenteRepository atendenteRepository;
	@Autowired
	private LojaRepository lojaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiGratificacaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		new Principal(atendenteRepository, lojaRepository).start();
	}
}
