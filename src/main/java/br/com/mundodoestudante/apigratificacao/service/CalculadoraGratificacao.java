package br.com.mundodoestudante.apigratificacao.service;

import br.com.mundodoestudante.apigratificacao.model.Atendente;
import br.com.mundodoestudante.apigratificacao.model.Loja;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@Service
public class CalculadoraGratificacao implements ICalculadoraGratificacao {

    private static final int PRIMEIRO_COLOCADO = 0;
    private static final int SEGUNDO_COLOCADO = 1;
    private static final int TERCEIRO_COLOCADO = 2;
    private final int SEMANA_MES = 6;
    private final BigDecimal BONUS_PRIMEIRO_COLOCADO = new BigDecimal("50.00");
    private final BigDecimal BONUS_SEGUNDO_COLOCADO = new BigDecimal("25.00");

    @Override
    public void calcularOperacao(Loja loja) {
        var listaDeAtendentes = loja.getAtendentes();

        switch (loja.getNome()) {
            case "Mundo" -> this.calculadoraMundo(listaDeAtendentes);
            case "Lápis" -> this.calculadoraLapis(listaDeAtendentes);
            case "Planeta" -> this.calculadoraPlaneta(listaDeAtendentes);
            case "Sonho" -> this.calculadoraSonho(listaDeAtendentes);
            case "Casa" -> this.calculadoraCasa(listaDeAtendentes);
            default -> System.out.println("Verifique se há alguma calculadora para essa loja");
        }
    }

    private void calculadoraMundo(List<Atendente> atendentes) {
        var percentualPrimeiroColocado = new BigDecimal("0.012");
        var percentualSegundoColocado = new BigDecimal("0.008");
        var percentualTerceiroColocado = new BigDecimal("0.004");
        var percentualDemaisColocados = new BigDecimal("0.002");
        this.escolherCalculadora(atendentes, percentualPrimeiroColocado, percentualSegundoColocado, percentualTerceiroColocado, percentualDemaisColocados);
    }

    private void calculadoraLapis(List<Atendente> atendentes) {
        var percentualPrimeiroColocado = new BigDecimal("0.012");
        var percentualSegundoColocado = new BigDecimal("0.008");
        var percentualTerceiroColocado = new BigDecimal("0.004");
        var percentualDemaisColocados = new BigDecimal("0.002");
        this.escolherCalculadora(atendentes, percentualPrimeiroColocado, percentualSegundoColocado, percentualTerceiroColocado, percentualDemaisColocados);
    }

    private void calculadoraPlaneta(List<Atendente> atendentes) {
        var percentualPrimeiroColocado = new BigDecimal("0.012");
        var percentualSegundoColocado = new BigDecimal("0.008");
        var percentualTerceiroColocado = new BigDecimal("0.004");
        var percentualDemaisColocados = new BigDecimal("0.002");
        this.escolherCalculadora(atendentes, percentualPrimeiroColocado, percentualSegundoColocado, percentualTerceiroColocado, percentualDemaisColocados);
    }

    private void calculadoraSonho(List<Atendente> atendentes) {
        var percentualPrimeiroColocado = new BigDecimal("0.012");
        var percentualSegundoColocado = new BigDecimal("0.008");
        var percentualTerceiroColocado = new BigDecimal("0.004");
        var percentualDemaisColocados = new BigDecimal("0.002");
        this.escolherCalculadora(atendentes, percentualPrimeiroColocado, percentualSegundoColocado, percentualTerceiroColocado, percentualDemaisColocados);
    }

    private void calculadoraCasa(List<Atendente> atendentes) {
        var percentualPrimeiroColocado = new BigDecimal("0.010");
        var percentualSegundoColocado = new BigDecimal("0.005");
        var percentualTerceiroColocado = new BigDecimal("0.002");
        var percentualDemaisColocados = new BigDecimal("0.001");
        this.escolherCalculadora(atendentes, percentualPrimeiroColocado, percentualSegundoColocado, percentualTerceiroColocado, percentualDemaisColocados);
    }

    private void escolherCalculadora(List<Atendente> atendentes, BigDecimal percentualPrimeiroColocado, BigDecimal percentualSegundoColocado, BigDecimal percentualTerceiroColocado, BigDecimal percentualDemaisColocados) {
        var condicao = new AtomicBoolean(false);

        atendentes.forEach(atendente -> {
            atendente.getAtendimentos().forEach(atendimento -> {
                if (atendimento > 0) {
                    condicao.set(true);
                }
            });
        });

        if (condicao.get()) {
            this.calculadoraComAtendimentos(atendentes, percentualPrimeiroColocado, percentualSegundoColocado, percentualTerceiroColocado, percentualDemaisColocados);
        } else {
            this.calculadoraComum(atendentes, percentualPrimeiroColocado, percentualSegundoColocado, percentualTerceiroColocado, percentualDemaisColocados);
        }
    }

    private void calculadoraComAtendimentos(List<Atendente> atendentes, BigDecimal percentualPrimeiroColocado, BigDecimal percentualSegundoColocado, BigDecimal percentualTerceiroColocado, BigDecimal percentualDemaisColocados) {
        for (int semana = 0; semana < SEMANA_MES; semana++) {
            final int semanaAtual = semana;
            var listaOdenada = atendentes.stream().sorted(Comparator.comparing(atendente -> atendente.getVendas().get(semanaAtual))).collect(Collectors.toList());
            Collections.reverse(listaOdenada);
            for (int i = 0; i < listaOdenada.size(); i++) {
                Atendente atendente = listaOdenada.get(i);
                BigDecimal gratificacao;
                switch (i) {
                    case PRIMEIRO_COLOCADO ->
                            gratificacao = atendente.getVendas().get(semana).multiply(percentualPrimeiroColocado);
                    case SEGUNDO_COLOCADO ->
                            gratificacao = atendente.getVendas().get(semana).multiply(percentualSegundoColocado);
                    case TERCEIRO_COLOCADO ->
                            gratificacao = atendente.getVendas().get(semana).multiply(percentualTerceiroColocado);
                    default -> gratificacao = atendente.getVendas().get(semana).multiply(percentualDemaisColocados);
                }
                atendente.registraGratificacao(gratificacao);
            }


            var listaOdenadaPorAtendimento = atendentes.stream().sorted(Comparator.comparing(a -> a.getAtendimentos().get(semanaAtual))).collect(Collectors.toList());
            Collections.reverse(listaOdenadaPorAtendimento);
            for (int i = 0; i < listaOdenadaPorAtendimento.size(); i++) {
                var atendente = listaOdenadaPorAtendimento.get(i);
                var quantidadeAtendimentos = atendente.getAtendimentos().get(semanaAtual);
                if (quantidadeAtendimentos > 0) {
                    switch (i) {
                        case PRIMEIRO_COLOCADO -> atendente.receberBonificacao(this.BONUS_PRIMEIRO_COLOCADO);
                        case SEGUNDO_COLOCADO -> atendente.receberBonificacao(this.BONUS_SEGUNDO_COLOCADO);
                    }
                }
            }
        }
    }

    private void calculadoraComum(List<Atendente> atendentes, BigDecimal percentualPrimeiroColocado, BigDecimal percentualSegundoColocado, BigDecimal percentualTerceiroColocado, BigDecimal percentualDemaisColocados) {
        for (int semana = 0; semana < SEMANA_MES; semana++) {
            final int semanaAtual = semana;
            var listaOdenada = atendentes.stream().sorted(Comparator.comparing(atendente -> atendente.getVendas().get(semanaAtual))).collect(Collectors.toList());
            Collections.reverse(listaOdenada);
            for (int i = 0; i < listaOdenada.size(); i++) {
                Atendente atendente = listaOdenada.get(i);
                BigDecimal gratificacao;
                switch (i) {
                    case PRIMEIRO_COLOCADO -> {
                        gratificacao = atendente.getVendas().get(semana).multiply(percentualPrimeiroColocado);
                        var vendas = atendente.getVendas().get(semana);
                        if (vendas.compareTo(BigDecimal.ZERO) > 0) {
                            atendente.receberBonificacao(this.BONUS_PRIMEIRO_COLOCADO);
                        }
                    }
                    case SEGUNDO_COLOCADO -> {
                        gratificacao = atendente.getVendas().get(semana).multiply(percentualSegundoColocado);
                        var vendas = atendente.getVendas().get(semana);
                        if (vendas.compareTo(BigDecimal.ZERO) > 0) {
                            atendente.receberBonificacao(this.BONUS_SEGUNDO_COLOCADO);
                        }
                    }
                    case TERCEIRO_COLOCADO ->
                            gratificacao = atendente.getVendas().get(semana).multiply(percentualTerceiroColocado);
                    default -> gratificacao = atendente.getVendas().get(semana).multiply(percentualDemaisColocados);
                }
                atendente.registraGratificacao(gratificacao);
            }
        }
    }
}
