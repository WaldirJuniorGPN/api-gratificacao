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

        costa.gravarVendasPrimeiraSemna("4066,30");
        grasielly.gravarVendasPrimeiraSemna("2845,56");
        isabele.gravarVendasPrimeiraSemna("1352,13");
        janaina.gravarVendasPrimeiraSemna("3882,63");
        julia.gravarVendasPrimeiraSemna("1778,35");
        juliaLapis.gravarVendasPrimeiraSemna("1778,35");
        kawan.gravarVendasPrimeiraSemna("2643,88");
        lucas.gravarVendasPrimeiraSemna("44,95");
        loja.gravarVendasPrimeiraSemna("3053,92");
        nailton.gravarVendasPrimeiraSemna("3631,14");
        pedro.gravarVendasPrimeiraSemna("3,40");
        samuel.gravarVendasPrimeiraSemna("2596,23");
        thaina.gravarVendasPrimeiraSemna("8278,39");
        vinicius.gravarVendasPrimeiraSemna("3522,91");

        alvaro.gravarVendasSegundaSemana("59,60");
        grasielly.gravarVendasSegundaSemana("11585,78");
        isabele.gravarVendasSegundaSemana("5518,15");
        janaina.gravarVendasSegundaSemana("10409,35");
        julia.gravarVendasSegundaSemana("5499,18");
        juliaLapis.gravarVendasSegundaSemana("5499,18");
        kawan.gravarVendasSegundaSemana("5631,71");
        lucas.gravarVendasSegundaSemana("21,77");
        loja.gravarVendasSegundaSemana("13064,46");
        nailton.gravarVendasSegundaSemana("13213,96");
        pedro.gravarVendasSegundaSemana("4985,12");
        samuel.gravarVendasSegundaSemana("23420,74");
        thaina.gravarVendasSegundaSemana("33541,28");
        vinicius.gravarVendasSegundaSemana("9737,80");

        alvaro.gravarVendasTerceiraSemana("367,21");
        grasielly.gravarVendasTerceiraSemana("12193,06");
        janaina.gravarVendasTerceiraSemana("14218,98");
        kawan.gravarVendasTerceiraSemana("16368,32");
        loja.gravarVendasTerceiraSemana("12371,00");
        loja.gravarVendasTerceiraSemana("379,51");
        nailton.gravarVendasTerceiraSemana("11039,49");
        pedro.gravarVendasTerceiraSemana("5423,51");
        samuel.gravarVendasTerceiraSemana("10591,93");
        thaina.gravarVendasTerceiraSemana("32159,41");
        vinicius.gravarVendasTerceiraSemana("10337,51");

        alvaro.gravarVendasQuartaSemana("36,97");
        grasielly.gravarVendasQuartaSemana("8337,49");
        janaina.gravarVendasQuartaSemana("6208,06");
        kawan.gravarVendasQuartaSemana("8372,46");
        loja.gravarVendasQuartaSemana("7795,25");
        loja.gravarVendasQuartaSemana("141,23");
        nailton.gravarVendasQuartaSemana("10286,36");
        nailton.gravarVendasQuartaSemana("43,88");
        pedro.gravarVendasQuartaSemana("7822,53");
        samuel.gravarVendasQuartaSemana("6017,46");
        thaina.gravarVendasQuartaSemana("16050,78");
        vinicius.gravarVendasQuartaSemana("9037,42");

        alvaro.gravarVendasQuintaSemana("111,81");
        costa.gravarVendasQuintaSemana("16,45");
        grasielly.gravarVendasQuintaSemana("2718,42");
        janaina.gravarVendasQuintaSemana("373,83");
        kawan.gravarVendasQuintaSemana("7153,47");
        loja.gravarVendasQuintaSemana("3807,67");
        loja.gravarVendasQuintaSemana("6,67");
        nailton.gravarVendasQuintaSemana("5671,85");
        pedro.gravarVendasQuintaSemana("2670,72");
        samuel.gravarVendasQuintaSemana("4301,55");
        thaina.gravarVendasQuintaSemana("10136,22");
        vinicius.gravarVendasQuintaSemana("6547,72");

        //LÁPIS NA MÃO
        cintiane.gravarVendasPrimeiraSemna("6,00");
        erik.gravarVendasPrimeiraSemna("1636,80");
        guilherme.gravarVendasPrimeiraSemna("1189,99");
        kauanLapis.gravarVendasPrimeiraSemna("1027,80");
        lincoln.gravarVendasPrimeiraSemna("1886,16");
        lojaLapis.gravarVendasPrimeiraSemna("769,74");
        michael.gravarVendasPrimeiraSemna("4367,00");
        rodrigues.gravarVendasPrimeiraSemna("620,55");
        wal.gravarVendasPrimeiraSemna("3097,03");


        cintiane.gravarVendasSegundaSemana("50,00");
        erik.gravarVendasSegundaSemana("8755,46");
        guilherme.gravarVendasSegundaSemana("6968,60");
        juliaLapis.gravarVendasSegundaSemana("1767,53");
        kauanLapis.gravarVendasSegundaSemana("5128,22");
        lincoln.gravarVendasSegundaSemana("4170,75");
        lojaLapis.gravarVendasSegundaSemana("4943,48");
        michael.gravarVendasSegundaSemana("13273,11");
        rodrigues.gravarVendasSegundaSemana("7136,50");
        wal.gravarVendasSegundaSemana("10986,52");

        cintiane.gravarVendasTerceiraSemana("294,05");
        erik.gravarVendasTerceiraSemana("3622,61");
        guilherme.gravarVendasTerceiraSemana("19,90");
        juliaLapis.gravarVendasTerceiraSemana("4508,93");
        kauanLapis.gravarVendasTerceiraSemana("6818,18");
        lincoln.gravarVendasTerceiraSemana("2101,37");
        lojaLapis.gravarVendasTerceiraSemana("1985,08");
        michael.gravarVendasTerceiraSemana("10484,44");
        rodrigues.gravarVendasTerceiraSemana("1334,73");
        wal.gravarVendasTerceiraSemana("13268,30");

        amanda.gravarVendasQuartaSemana("1902,66");
        cintiane.gravarVendasQuartaSemana("1035,82");
        erik.gravarVendasQuartaSemana("3323,36");
        juliaLapis.gravarVendasQuartaSemana("9736,24");
        kauanLapis.gravarVendasQuartaSemana("3457,54");
        lincoln.gravarVendasQuartaSemana("2198,86");
        lojaLapis.gravarVendasQuartaSemana("902,38");
        michael.gravarVendasQuartaSemana("7161,19");
        rodrigues.gravarVendasQuartaSemana("1585,02");
        wal.gravarVendasQuartaSemana("7572,67");

        amanda.gravarVendasQuintaSemana("1315,99");
        cintiane.gravarVendasQuintaSemana("1036,83");
        erik.gravarVendasQuintaSemana("3044,54");
        juliaLapis.gravarVendasQuintaSemana("5828,76");
        kauanLapis.gravarVendasQuintaSemana("1230,59");
        lincoln.gravarVendasQuintaSemana("1264,05");
        lojaLapis.gravarVendasQuintaSemana("1213,50");
        michael.gravarVendasQuintaSemana("4929,09");
        rodrigues.gravarVendasQuintaSemana("2249,08");
        wal.gravarVendasQuintaSemana("3089,55");


        //SONHO DE BEBÊ

        bruna.gravarVendasPrimeiraSemna("3146,68");
        camila.gravarVendasPrimeiraSemna("147,33");
        karol.gravarVendasPrimeiraSemna("1790,86");
        sara.gravarVendasPrimeiraSemna("2850,99");
        lojaSonho.gravarVendasPrimeiraSemna("49,97");

        alef.gravarVendasSegundaSemana("142,78");
        bruna.gravarVendasSegundaSemana("6407,15");
        camila.gravarVendasSegundaSemana("831,76");
        dani.gravarVendasSegundaSemana("4476,68");
        karol.gravarVendasSegundaSemana("10862,42");
        sara.gravarVendasSegundaSemana("12645,04");
        lojaSonho.gravarVendasSegundaSemana("330,88");
        isabeleSonho.gravarVendasSegundaSemana("3447,00");

        beatrizSonho.gravarVendasTerceiraSemana("2032,57");
        bruna.gravarVendasTerceiraSemana("9950,74");
        dani.gravarVendasTerceiraSemana("1251,09");
        lojaSonho.gravarVendasTerceiraSemana("190,76");
        karol.gravarVendasTerceiraSemana("5385,23");
        sara.gravarVendasTerceiraSemana("1410,50");
        lojaSonho.gravarVendasTerceiraSemana("174,69");
        isabeleSonho.gravarVendasTerceiraSemana("3526,75");

        bruna.gravarVendasQuartaSemana("5382,08");
        dani.gravarVendasQuartaSemana("1773,38");
        karol.gravarVendasQuartaSemana("4062,91");
        sara.gravarVendasQuartaSemana("4315,49");
        lojaSonho.gravarVendasQuartaSemana("42,90");
        isabeleSonho.gravarVendasQuartaSemana("4512,83");

        bruna.gravarVendasQuintaSemana("5671,90");
        dani.gravarVendasQuintaSemana("99,90");
        karol.gravarVendasQuintaSemana("5301,13");
        sara.gravarVendasQuintaSemana("4455,08");
        lojaSonho.gravarVendasQuintaSemana("2953,80");
        isabeleSonho.gravarVendasQuintaSemana("3504,07");

        // CASA DO BEBÊ
        beatrizCasa.gravarVendasPrimeiraSemna("1515,33");
        juliana.gravarVendasPrimeiraSemna("137,78");
        lojaCasa.gravarVendasPrimeiraSemna("297,00");
        valeria.gravarVendasPrimeiraSemna("2140,29");
        camilaCasa.gravarVendasPrimeiraSemna("147,33");

        beatrizCasa.gravarVendasSegundaSemana("11553,92");
        camilaCasa.gravarVendasSegundaSemana("2361,74");
        camilaCasa.gravarVendasSegundaSemana("831,76");
        juliana.gravarVendasSegundaSemana("8355,04");
        lojaCasa.gravarVendasSegundaSemana("145,75");
        lojaCasa.gravarVendasSegundaSemana("741,00");

        beatrizCasa.gravarVendasTerceiraSemana("4423,94");
        beatrizCasa.gravarVendasTerceiraSemana("2032,57");
        camilaCasa.gravarVendasTerceiraSemana("10664,92");
        juliana.gravarVendasTerceiraSemana("3936,58");
        lojaCasa.gravarVendasTerceiraSemana("173,76");
        lojaCasa.gravarVendasTerceiraSemana("626,65");

        beatrizCasa.gravarVendasQuartaSemana("5683,52");
        camilaCasa.gravarVendasQuartaSemana("6108,59");
        juliana.gravarVendasQuartaSemana("1525,69");
        lojaCasa.gravarVendasQuartaSemana("255,57");
        lojaCasa.gravarVendasQuartaSemana("485,00");

        beatrizCasa.gravarVendasQuintaSemana("1437,71");
        camilaCasa.gravarVendasQuintaSemana("6963,30");
        juliana.gravarVendasQuintaSemana("2029,03");
        lojaCasa.gravarVendasQuintaSemana("35,98");
        lojaCasa.gravarVendasQuintaSemana("457,00");


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
