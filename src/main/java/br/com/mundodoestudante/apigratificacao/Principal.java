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
        var janaina = new Atendente("Janaína", ELoja.MUNDO);
        var kawan = new Atendente("Kawan", ELoja.MUNDO);
        var lucas = new Atendente("Lucas", ELoja.MUNDO);
        var loja = new Atendente("Loja", ELoja.MUNDO);
        var nailton = new Atendente("Nailton", ELoja.MUNDO);
        var pedro = new Atendente("Pedro", ELoja.MUNDO);
        var samuel = new Atendente("Samuel", ELoja.MUNDO);
        var thaina = new Atendente("Thainá", ELoja.MUNDO);
        var vinicius = new Atendente("Vinícius", ELoja.MUNDO);
        var alvaro = new Atendente("Álvaro", ELoja.MUNDO);
        var tainara = new Atendente("Tainara", ELoja.MUNDO);

        var amanda = new Atendente("Amanda", ELoja.LAPIS);
        var cintiane = new Atendente("Cintiane", ELoja.LAPIS);
        var erik = new Atendente("Erik", ELoja.LAPIS);
        var guilherme = new Atendente("Guilherme", ELoja.LAPIS);
        var julia = new Atendente("Julia Lápis", ELoja.LAPIS);
        var kauanLapis = new Atendente("Kauã Lápis", ELoja.LAPIS);
        var lincoln = new Atendente("Lincoln", ELoja.LAPIS);
        var lojaLapis = new Atendente("Loja Lápis", ELoja.LAPIS);
        var michael = new Atendente("Michael", ELoja.LAPIS);
        var gabriel = new Atendente("Rodrigues", ELoja.LAPIS);
        var wal = new Atendente("Wal", ELoja.LAPIS);
        var higor = new Atendente("Higor", ELoja.LAPIS);

        var bruna = new Atendente("Bruna", ELoja.SONHO);
        var camila = new Atendente("Camila", ELoja.SONHO);
        var karol = new Atendente("Karol", ELoja.SONHO);
        var sara = new Atendente("Sara", ELoja.SONHO);
        var lojaSonho = new Atendente("Loja Sonho", ELoja.SONHO);
        var alef = new Atendente("Alef", ELoja.SONHO);
        var dani = new Atendente("Dani", ELoja.SONHO);
        var isabeleSonho = new Atendente("Isabele Sonho", ELoja.SONHO);
        var beatrizSonho = new Atendente("Beatriz Sonho", ELoja.SONHO);
        var valeriaSonho = new Atendente("Valéria Sonho", ELoja.SONHO);

        var beatrizCasa = new Atendente("Beatriz Casa", ELoja.CASA);
        var juliana = new Atendente("Juliana", ELoja.CASA);
        var lojaCasa = new Atendente("Loja Casa", ELoja.CASA);
        var valeriaCasa = new Atendente("Valéria", ELoja.CASA);
        var camilaCasa = new Atendente("Camila Casa", ELoja.CASA);

        costa.gravarVendasPrimeiraSemna("1117,85", 19);
        janaina.gravarVendasPrimeiraSemna("1938,09", 45);
        kawan.gravarVendasPrimeiraSemna("4375,14", 67);
        lucas.gravarVendasPrimeiraSemna("288,85", 14);
        loja.gravarVendasPrimeiraSemna("1857,47", 64);
        nailton.gravarVendasPrimeiraSemna("34,89", 2);
        pedro.gravarVendasPrimeiraSemna("1724,12", 22);
        samuel.gravarVendasPrimeiraSemna("2108,10", 39);
        loja.gravarVendasPrimeiraSemna("41,39", 1);
        tainara.gravarVendasPrimeiraSemna("1759,64", 34);
        thaina.gravarVendasPrimeiraSemna("5301,67", 53);
        vinicius.gravarVendasPrimeiraSemna("2063,96", 39);

        costa.gravarVendasSegundaSemna("2126,19", 37);
        janaina.gravarVendasSegundaSemna("7802,31", 142);
        kawan.gravarVendasSegundaSemna("13538,76", 176);
        lucas.gravarVendasSegundaSemna("1229,33", 39);
        loja.gravarVendasSegundaSemna("2861,05", 103);
        pedro.gravarVendasSegundaSemna("8337,18", 100);
        samuel.gravarVendasSegundaSemna("8761,48", 119);
        tainara.gravarVendasSegundaSemna("4215,48", 63);
        thaina.gravarVendasSegundaSemna("10602,24", 151);
        vinicius.gravarVendasSegundaSemna("9554,65", 110);

        costa.gravarVendasTerceiraSemna("5232,60", 91);
        janaina.gravarVendasTerceiraSemna("6240,90", 106);
        kawan.gravarVendasTerceiraSemna("9320,58", 137);
        lucas.gravarVendasTerceiraSemna("2949,58", 49);
        loja.gravarVendasTerceiraSemna("1685,21", 72);
        pedro.gravarVendasTerceiraSemna("7094,18", 86);
        samuel.gravarVendasTerceiraSemna("3767,62", 55);
        thaina.gravarVendasTerceiraSemna("6531,63", 82);
        vinicius.gravarVendasTerceiraSemna("5266,59", 89);

        costa.gravarVendasQuartaSemna("7104,49", 107);
        loja.gravarVendasQuartaSemna("34,18", 1);
        janaina.gravarVendasQuartaSemna("6674,70", 96);
        kawan.gravarVendasQuartaSemna("6418,44", 111);
        lucas.gravarVendasQuartaSemna("1536,74", 34);
        loja.gravarVendasQuartaSemna("1284,51", 39);
        pedro.gravarVendasQuartaSemna("9002,71", 129);
        samuel.gravarVendasQuartaSemna("3652,45", 75);
        thaina.gravarVendasQuartaSemna("3158,23", 42);
        vinicius.gravarVendasQuartaSemna("5077,17", 87);

        costa.gravarVendasQuintaSemna("1694,59", 45);
        janaina.gravarVendasQuintaSemna("3358,48", 68);
        kawan.gravarVendasQuintaSemna("4791,75", 49);
        lucas.gravarVendasQuintaSemna("1347,06", 32);
        loja.gravarVendasQuintaSemna("886,20", 36);
        pedro.gravarVendasQuintaSemna("7454,61", 113);
        samuel.gravarVendasQuintaSemna("2340,65", 35);
        thaina.gravarVendasQuintaSemna("2094,82", 39);
        vinicius.gravarVendasQuintaSemna("3260,66", 66);

        //LÁPIS NA MÃO
        amanda.gravarVendasPrimeiraSemna("4429,11", 98);
        cintiane.gravarVendasPrimeiraSemna("10,97", 2);
        gabriel.gravarVendasPrimeiraSemna("2844,30", 50);
        higor.gravarVendasPrimeiraSemna("3089,52", 79);
        julia.gravarVendasPrimeiraSemna("3646,30", 88);
        lojaLapis.gravarVendasPrimeiraSemna("119,06", 15);
        lojaLapis.gravarVendasPrimeiraSemna("25,00", 2);
        wal.gravarVendasPrimeiraSemna("1558,83", 25);

        amanda.gravarVendasSegundaSemna("13503,40", 261);
        cintiane.gravarVendasSegundaSemna("51,57", 5);
        erik.gravarVendasSegundaSemna("1114,10", 37);
        gabriel.gravarVendasSegundaSemna("4418,79", 115);
        higor.gravarVendasSegundaSemna("5543,13", 160);
        julia.gravarVendasSegundaSemna("9248,06", 229);
        lojaLapis.gravarVendasSegundaSemna("667,78", 20);
        lojaLapis.gravarVendasSegundaSemna("218,59", 10);

        amanda.gravarVendasTerceiraSemna("9291,10", 212);
        erik.gravarVendasTerceiraSemna("5883,31", 123);
        gabriel.gravarVendasTerceiraSemna("2071,19", 41);
        higor.gravarVendasTerceiraSemna("5978,68", 127);
        julia.gravarVendasTerceiraSemna("4559,64", 90);
        lojaLapis.gravarVendasTerceiraSemna("613,96", 16);
        lojaLapis.gravarVendasTerceiraSemna("293,00", 6);

        amanda.gravarVendasQuartaSemna("9235,31", 187);
        erik.gravarVendasQuartaSemna("5188,44", 114);
        gabriel.gravarVendasQuartaSemna("1271,87", 38);
        higor.gravarVendasQuartaSemna("5506,80", 112);
        julia.gravarVendasQuartaSemna("4606,29", 136);
        lojaLapis.gravarVendasQuartaSemna("911,37", 16);
        lojaLapis.gravarVendasQuartaSemna("107,00", 7);
        lojaLapis.gravarVendasQuartaSemna("10,48", 1);

        amanda.gravarVendasQuintaSemna("6081,18", 144);
        erik.gravarVendasQuintaSemna("2328,03", 82);
        gabriel.gravarVendasQuintaSemna("757,28", 20);
        higor.gravarVendasQuintaSemna("2491,29", 84);
        julia.gravarVendasQuintaSemna("2853,82", 93);
        lojaLapis.gravarVendasQuintaSemna("171,43", 7);
        lojaLapis.gravarVendasQuintaSemna("53,00", 2);

        //SONHO DE BEBÊ
        bruna.gravarVendasPrimeiraSemna("7720,48", 25);
        camila.gravarVendasPrimeiraSemna("4307,40", 31);
        dani.gravarVendasPrimeiraSemna("676,47", 6);
        isabeleSonho.gravarVendasPrimeiraSemna("3053,12", 19);
        karol.gravarVendasPrimeiraSemna("8337,73", 39);
        lojaSonho.gravarVendasPrimeiraSemna("167,85", 8);

        beatrizSonho.gravarVendasSegundaSemna("1390,77", 5);
        bruna.gravarVendasSegundaSemna("11312,77", 92);
        camila.gravarVendasSegundaSemna("13222,33", 65);
        dani.gravarVendasSegundaSemna("1261,56", 12);
        isabeleSonho.gravarVendasSegundaSemna("2369,72", 20);
        karol.gravarVendasSegundaSemna("12883,59", 77);
        lojaSonho.gravarVendasSegundaSemna("857,05", 13);

        bruna.gravarVendasTerceiraSemna("12154,45", 58);
        camila.gravarVendasTerceiraSemna("10424,40", 62);
        dani.gravarVendasTerceiraSemna("672,82", 8);
        karol.gravarVendasTerceiraSemna("6930,31", 54);
        lojaSonho.gravarVendasTerceiraSemna("396,33", 11);

        bruna.gravarVendasQuartaSemna("8589,58", 40);
        camila.gravarVendasQuartaSemna("8961,33", 43);
        dani.gravarVendasQuartaSemna("337,57", 5);
        karol.gravarVendasQuartaSemna("7685,96", 39);
        lojaSonho.gravarVendasQuartaSemna("255,47", 8);

        bruna.gravarVendasQuintaSemna("1647,26", 15);
        camila.gravarVendasQuintaSemna("7865,31", 31);
        dani.gravarVendasQuintaSemna("44,00", 1);
        karol.gravarVendasQuintaSemna("4120,79", 19);
        sara.gravarVendasQuintaSemna("3390,65", 14);
        lojaSonho.gravarVendasQuintaSemna("2674,72", 5);
        valeriaSonho.gravarVendasQuintaSemna("2999,18", 9);

        // CASA DO BEBÊ
        beatrizCasa.gravarVendasPrimeiraSemna("3516,81", 19);
        juliana.gravarVendasPrimeiraSemna("3580,07", 20);
        lojaCasa.gravarVendasPrimeiraSemna("65,80", 2);
        lojaCasa.gravarVendasPrimeiraSemna("562,00", 1);
        valeriaCasa.gravarVendasPrimeiraSemna("1771,28", 16);

        beatrizCasa.gravarVendasSegundaSemna("10646,64", 49);
        beatrizCasa.gravarVendasSegundaSemna("1390,77", 5);
        juliana.gravarVendasSegundaSemna("3489,07", 26);
        lojaCasa.gravarVendasSegundaSemna("9,99", 1);
        lojaCasa.gravarVendasSegundaSemna("791,85",0);
        valeriaCasa.gravarVendasSegundaSemna("11747,71", 48);

        beatrizCasa.gravarVendasTerceiraSemna("4949,58", 29);
        juliana.gravarVendasTerceiraSemna("7132,13", 28);
        lojaCasa.gravarVendasTerceiraSemna("115,98", 0);
        lojaCasa.gravarVendasTerceiraSemna("503,00", 0);
        valeriaCasa.gravarVendasTerceiraSemna("4609,84", 33);

        beatrizCasa.gravarVendasQuartaSemna("4087,96", 25);
        juliana.gravarVendasQuartaSemna("3505,93", 19);
        lojaCasa.gravarVendasQuartaSemna("400,00", 0);
        valeriaCasa.gravarVendasQuartaSemna("6859,06", 33);

        beatrizCasa.gravarVendasQuintaSemna("1833,97", 17);
        juliana.gravarVendasQuintaSemna("4451,17", 31);
        lojaCasa.gravarVendasQuintaSemna("298,00", 0);
        valeriaCasa.gravarVendasQuintaSemna("3762,94", 23);
        valeriaCasa.gravarVendasQuintaSemna("2999,18", 9);


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
