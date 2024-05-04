package br.com.mundodoestudante.apigratificacao;

import br.com.mundodoestudante.apigratificacao.model.Atendente;
import br.com.mundodoestudante.apigratificacao.model.ELoja;
import br.com.mundodoestudante.apigratificacao.model.Loja;
import br.com.mundodoestudante.apigratificacao.repository.AtendenteRepository;
import br.com.mundodoestudante.apigratificacao.repository.LojaRepository;
import br.com.mundodoestudante.apigratificacao.service.CalculadoraGratificacao;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

@Component
public class Principal {

    private AtendenteRepository atendenteRepository;
    private LojaRepository lojaRepository;
    private Loja mundo = new Loja("Mundo");
    private Loja lapis = new Loja("Lápis");
    private Loja planeta = new Loja("Planeta");
    private Loja sonho = new Loja("Sonho");
    private Loja casa = new Loja("Casa");
    private CalculadoraGratificacao calculadora = new CalculadoraGratificacao();

    public Principal() {
    }

    public Principal(AtendenteRepository atendenteRepository, LojaRepository lojaRepository) {
        this.atendenteRepository = atendenteRepository;
        this.lojaRepository = lojaRepository;
    }

    public void start() {

        var costa = new Atendente("Costa", ELoja.MUNDO);
        var grasielly = new Atendente("Grasielly", ELoja.MUNDO);
        var isabele = new Atendente("Isabele", ELoja.MUNDO);
        var janaina = new Atendente("Janaína", ELoja.MUNDO);
        var julia = new Atendente("Júlia", ELoja.MUNDO);
        var kawan = new Atendente("Kawan", ELoja.MUNDO);
        var lucas = new Atendente("Lucas", ELoja.MUNDO);
        var loja = new Atendente("Loja", ELoja.MUNDO);
        var nailton = new Atendente("Nailton", ELoja.MUNDO);
        var pedro = new Atendente("Pedro", ELoja.MUNDO);
        var samuel = new Atendente("Samuel", ELoja.MUNDO);
        var thaina = new Atendente("Thainá", ELoja.MUNDO);
        var vinicius = new Atendente("Vinícius", ELoja.MUNDO);
        var alvaro = new Atendente("Álvaro", ELoja.MUNDO);

        var amanda = new Atendente("Amanda", ELoja.LAPIS);
        var cintiane = new Atendente("Cintiane", ELoja.LAPIS);
        var erik = new Atendente("Erik", ELoja.LAPIS);
        var guilherme = new Atendente("Guilherme", ELoja.LAPIS);
        var juliaLapis = new Atendente("Julia Lápis", ELoja.LAPIS);
        var kauanLapis = new Atendente("Kauã Lápis", ELoja.LAPIS);
        var lincoln = new Atendente("Lincoln", ELoja.LAPIS);
        var lojaLapis = new Atendente("Loja Lápis", ELoja.LAPIS);
        var michael = new Atendente("Michael", ELoja.LAPIS);
        var rodrigues = new Atendente("Rodrigues", ELoja.LAPIS);
        var wal = new Atendente("Wal", ELoja.LAPIS);

        var bruna = new Atendente("Bruna", ELoja.SONHO);
        var camila = new Atendente("Camila", ELoja.SONHO);
        var karol = new Atendente("Karol", ELoja.SONHO);
        var sara = new Atendente("Sara", ELoja.SONHO);
        var lojaSonho = new Atendente("Loja Sonho", ELoja.SONHO);
        var alef = new Atendente("Alef", ELoja.SONHO);
        var dani = new Atendente("Dani", ELoja.SONHO);
        var isabeleSonho = new Atendente("Isabele Sonho", ELoja.SONHO);
        var beatrizSonho = new Atendente("Beatriz Sonho", ELoja.SONHO);

        var beatrizCasa = new Atendente("Beatriz Casa", ELoja.CASA);
        var juliana = new Atendente("Juliana", ELoja.CASA);
        var lojaCasa = new Atendente("Loja Casa", ELoja.CASA);
        var valeria = new Atendente("Valéria", ELoja.CASA);
        var camilaCasa = new Atendente("Camila Casa", ELoja.CASA);

        costa.gravarVendasPrimeiraSemna("0,00");
        grasielly.gravarVendasPrimeiraSemna("0,00");
        isabele.gravarVendasPrimeiraSemna("0,00");
        janaina.gravarVendasPrimeiraSemna("0,00");
        julia.gravarVendasPrimeiraSemna("0,00");
        kawan.gravarVendasPrimeiraSemna("0,00");
        lucas.gravarVendasPrimeiraSemna("0,00");
        loja.gravarVendasPrimeiraSemna("0,00");
        nailton.gravarVendasPrimeiraSemna("0,00");
        pedro.gravarVendasPrimeiraSemna("0,00");
        samuel.gravarVendasPrimeiraSemna("0,00");
        thaina.gravarVendasPrimeiraSemna("0,00");
        vinicius.gravarVendasPrimeiraSemna("0,00");

        alvaro.gravarVendasSegundaSemana("0,00");
        grasielly.gravarVendasSegundaSemana("0,00");
        isabele.gravarVendasSegundaSemana("0,00");
        janaina.gravarVendasSegundaSemana("0,00");
        julia.gravarVendasSegundaSemana("0,00");
        kawan.gravarVendasSegundaSemana("0,00");
        lucas.gravarVendasSegundaSemana("0,00");
        loja.gravarVendasSegundaSemana("0,00");
        nailton.gravarVendasSegundaSemana("0,00");
        pedro.gravarVendasSegundaSemana("0,00");
        samuel.gravarVendasSegundaSemana("0,00");
        thaina.gravarVendasSegundaSemana("0,00");
        vinicius.gravarVendasSegundaSemana("0,00");

        alvaro.gravarVendasTerceiraSemana("0,00");
        grasielly.gravarVendasTerceiraSemana("0,00");
        janaina.gravarVendasTerceiraSemana("0,00");
        kawan.gravarVendasTerceiraSemana("0,00");
        loja.gravarVendasTerceiraSemana("0,00");
        nailton.gravarVendasTerceiraSemana("0,00");
        pedro.gravarVendasTerceiraSemana("0,00");
        samuel.gravarVendasTerceiraSemana("0,00");
        thaina.gravarVendasTerceiraSemana("0,00");
        vinicius.gravarVendasTerceiraSemana("0,00");

        alvaro.gravarVendasQuartaSemana("0,00");
        grasielly.gravarVendasQuartaSemana("0,00");
        janaina.gravarVendasQuartaSemana("0,00");
        kawan.gravarVendasQuartaSemana("0,00");
        loja.gravarVendasQuartaSemana("0,00");
        nailton.gravarVendasQuartaSemana("0,00");
        pedro.gravarVendasQuartaSemana("0,00");
        samuel.gravarVendasQuartaSemana("0,00");
        thaina.gravarVendasQuartaSemana("0,00");
        vinicius.gravarVendasQuartaSemana("0,00");

        alvaro.gravarVendasQuintaSemana("0,00");
        costa.gravarVendasQuintaSemana("0,00");
        grasielly.gravarVendasQuintaSemana("0,00");
        janaina.gravarVendasQuintaSemana("0,00");
        kawan.gravarVendasQuintaSemana("0,00");
        loja.gravarVendasQuintaSemana("0,00");
        nailton.gravarVendasQuintaSemana("0,00");
        pedro.gravarVendasQuintaSemana("0,00");
        samuel.gravarVendasQuintaSemana("0,00");
        thaina.gravarVendasQuintaSemana("0,00");
        vinicius.gravarVendasQuintaSemana("0,00");

        //LÁPIS NA MÃO
        amanda.gravarVendasPrimeiraSemna("7315,06");
        cintiane.gravarVendasPrimeiraSemna("614,78");
        erik.gravarVendasPrimeiraSemna("1470,95");
        juliaLapis.gravarVendasPrimeiraSemna("5172,66");
        guilherme.gravarVendasPrimeiraSemna("0.00");
        kauanLapis.gravarVendasPrimeiraSemna("1767,86");
        lojaLapis.gravarVendasPrimeiraSemna("653,46");
        michael.gravarVendasPrimeiraSemna("4873,76");
        lincoln.gravarVendasPrimeiraSemna("0.00");
        rodrigues.gravarVendasPrimeiraSemna("1375,16");
        wal.gravarVendasPrimeiraSemna("5521,64");

        amanda.gravarVendasSegundaSemana("4942,53");
        cintiane.gravarVendasSegundaSemana("657,84");
        erik.gravarVendasSegundaSemana("1159,88");
        juliaLapis.gravarVendasSegundaSemana("6730,60");
        kauanLapis.gravarVendasSegundaSemana("1476,30");
        lojaLapis.gravarVendasSegundaSemana("446,28");
        michael.gravarVendasSegundaSemana("7813,91");
        rodrigues.gravarVendasSegundaSemana("2177,77");
        guilherme.gravarVendasSegundaSemana("0.00");
        lincoln.gravarVendasSegundaSemana("0.00");
        wal.gravarVendasSegundaSemana("3653,22");

        amanda.gravarVendasTerceiraSemana("6284,29");
        cintiane.gravarVendasTerceiraSemana("254,39");
        juliaLapis.gravarVendasTerceiraSemana("4604,24");
        kauanLapis.gravarVendasTerceiraSemana("1481,22");
        erik.gravarVendasTerceiraSemana("0.00");
        guilherme.gravarVendasTerceiraSemana("0.00");
        lincoln.gravarVendasTerceiraSemana("0.00");
        lojaLapis.gravarVendasTerceiraSemana("365,89");
        lojaLapis.gravarVendasTerceiraSemana("66,00");
        michael.gravarVendasTerceiraSemana("7283,55");
        rodrigues.gravarVendasTerceiraSemana("1621,25");
        wal.gravarVendasTerceiraSemana("3541,77");

        amanda.gravarVendasQuartaSemana("7628,99");
        cintiane.gravarVendasQuartaSemana("51,19");
        cintiane.gravarVendasQuartaSemana("57,87");
        juliaLapis.gravarVendasQuartaSemana("5506,85");
        erik.gravarVendasQuartaSemana("0.00");
        kauanLapis.gravarVendasQuartaSemana("1081,12");
        lincoln.gravarVendasQuartaSemana("0.00");
        lojaLapis.gravarVendasQuartaSemana("97,05");
        lojaLapis.gravarVendasQuartaSemana("107,00");
        michael.gravarVendasQuartaSemana("3076,97");
        rodrigues.gravarVendasQuartaSemana("1579,97");
        wal.gravarVendasQuartaSemana("7385,01");

        amanda.gravarVendasQuintaSemana("2574,61");
        cintiane.gravarVendasQuintaSemana("46,69");
        erik.gravarVendasQuintaSemana("0.00");
        juliaLapis.gravarVendasQuintaSemana("1908,37");
        kauanLapis.gravarVendasQuintaSemana("371,33");
        lincoln.gravarVendasQuintaSemana("0.00");
        lojaLapis.gravarVendasQuintaSemana("0,90");
        lojaLapis.gravarVendasQuintaSemana("14,00");
        michael.gravarVendasQuintaSemana("837,08");
        rodrigues.gravarVendasQuintaSemana("116,03");
        wal.gravarVendasQuintaSemana("1275,94");


        //SONHO DE BEBÊ

        bruna.gravarVendasPrimeiraSemna("0,00");
        camila.gravarVendasPrimeiraSemna("0,00");
        karol.gravarVendasPrimeiraSemna("0,00");
        sara.gravarVendasPrimeiraSemna("0,00");
        lojaSonho.gravarVendasPrimeiraSemna("0,00");

        alef.gravarVendasSegundaSemana("0,00");
        bruna.gravarVendasSegundaSemana("0,00");
        camila.gravarVendasSegundaSemana("0,00");
        dani.gravarVendasSegundaSemana("0,00");
        karol.gravarVendasSegundaSemana("0,00");
        sara.gravarVendasSegundaSemana("0,00");
        lojaSonho.gravarVendasSegundaSemana("0,00");
        isabeleSonho.gravarVendasSegundaSemana("0,00");

        beatrizSonho.gravarVendasTerceiraSemana("0,00");
        bruna.gravarVendasTerceiraSemana("0,00");
        dani.gravarVendasTerceiraSemana("0,00");
        lojaSonho.gravarVendasTerceiraSemana("0,00");
        karol.gravarVendasTerceiraSemana("0,00");
        sara.gravarVendasTerceiraSemana("0,00");
        lojaSonho.gravarVendasTerceiraSemana("0,00");
        isabeleSonho.gravarVendasTerceiraSemana("0,00");

        bruna.gravarVendasQuartaSemana("0,00");
        dani.gravarVendasQuartaSemana("0,00");
        karol.gravarVendasQuartaSemana("0,00");
        sara.gravarVendasQuartaSemana("0,00");
        lojaSonho.gravarVendasQuartaSemana("0,00");
        isabeleSonho.gravarVendasQuartaSemana("0,00");

        bruna.gravarVendasQuintaSemana("0,00");
        dani.gravarVendasQuintaSemana("0,00");
        karol.gravarVendasQuintaSemana("0,00");
        sara.gravarVendasQuintaSemana("0,00");
        lojaSonho.gravarVendasQuintaSemana("0,00");
        isabeleSonho.gravarVendasQuintaSemana("0,00");

        // CASA DO BEBÊ
        beatrizCasa.gravarVendasPrimeiraSemna("0,00");
        juliana.gravarVendasPrimeiraSemna("0,00");
        lojaCasa.gravarVendasPrimeiraSemna("0,00");
        valeria.gravarVendasPrimeiraSemna("0,00");
        camilaCasa.gravarVendasPrimeiraSemna("0,00");

        beatrizCasa.gravarVendasSegundaSemana("0,00");
        camilaCasa.gravarVendasSegundaSemana("0,00");
        camilaCasa.gravarVendasSegundaSemana("0,00");
        juliana.gravarVendasSegundaSemana("0,00");
        lojaCasa.gravarVendasSegundaSemana("0,00");
        lojaCasa.gravarVendasSegundaSemana("0,00");

        beatrizCasa.gravarVendasTerceiraSemana("0,00");
        beatrizCasa.gravarVendasTerceiraSemana("0,00");
        camilaCasa.gravarVendasTerceiraSemana("0,00");
        juliana.gravarVendasTerceiraSemana("0,00");
        lojaCasa.gravarVendasTerceiraSemana("0,00");
        lojaCasa.gravarVendasTerceiraSemana("0,00");

        beatrizCasa.gravarVendasQuartaSemana("0,00");
        camilaCasa.gravarVendasQuartaSemana("0,00");
        juliana.gravarVendasQuartaSemana("0,00");
        lojaCasa.gravarVendasQuartaSemana("0,00");
        lojaCasa.gravarVendasQuartaSemana("0,00");

        beatrizCasa.gravarVendasQuintaSemana("0,00");
        camilaCasa.gravarVendasQuintaSemana("0,00");
        juliana.gravarVendasQuintaSemana("0,00");
        lojaCasa.gravarVendasQuintaSemana("0,00");
        lojaCasa.gravarVendasQuintaSemana("0,00");


        for (Atendente atendente : Atendente.getAtendentes()) {
            switch (atendente.getNomeLoja()) {
                case MUNDO -> atendente.atribuirLoja(this.mundo);
                case LAPIS -> atendente.atribuirLoja(this.lapis);
                case PLANETA -> atendente.atribuirLoja(this.planeta);
                case SONHO -> atendente.atribuirLoja(this.sonho);
                case CASA -> atendente.atribuirLoja(this.casa);
            }
        }
        this.calculadora.calcularOperacao(this.mundo);
        this.calculadora.calcularOperacao(this.lapis);
        this.calculadora.calcularOperacao(this.planeta);
        this.calculadora.calcularOperacao(this.sonho);
        this.calculadora.calcularOperacao(this.casa);

        System.out.println("\n\n######\n\n");

        var listaMundo = this.mundo.getAtendentes().stream().sorted(Comparator.comparing(atendente -> atendente.getTotalVendas())).collect(Collectors.toList());
        Collections.reverse(listaMundo);
        listaMundo.forEach(System.out::println);

        System.out.println("\n\n######\n\n");

        var listaLapis = this.lapis.getAtendentes().stream().sorted(Comparator.comparing(atendente -> atendente.getTotalVendas())).collect(Collectors.toList());
        Collections.reverse(listaLapis);
        listaLapis.forEach(System.out::println);

        System.out.println("\n\n######\n\n");

        var listaPlaneta = this.planeta.getAtendentes().stream().sorted(Comparator.comparing(atendente -> atendente.getTotalVendas())).collect(Collectors.toList());
        Collections.reverse(listaPlaneta);
        listaPlaneta.forEach(System.out::println);

        System.out.println("\n\n######\n\n");

        var listaSonho = this.sonho.getAtendentes().stream().sorted(Comparator.comparing(atendente -> atendente.getTotalVendas())).collect(Collectors.toList());
        Collections.reverse(listaSonho);
        listaSonho.forEach(System.out::println);

        System.out.println("\n\n######\n\n");

        var listaCasa = this.casa.getAtendentes().stream().sorted(Comparator.comparing(atendente -> atendente.getTotalVendas())).collect(Collectors.toList());
        Collections.reverse(listaCasa);
        listaCasa.forEach(System.out::println);

    }

}
