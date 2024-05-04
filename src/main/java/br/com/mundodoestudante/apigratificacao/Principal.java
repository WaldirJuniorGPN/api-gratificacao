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
        var apoio = new Atendente("Apoio", ELoja.MUNDO);

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
        var valeriaSonho = new Atendente("Valéria Sonho", ELoja.SONHO);

        var beatrizCasa = new Atendente("Beatriz Casa", ELoja.CASA);
        var juliana = new Atendente("Juliana", ELoja.CASA);
        var lojaCasa = new Atendente("Loja Casa", ELoja.CASA);
        var valeria = new Atendente("Valéria", ELoja.CASA);
        var camilaCasa = new Atendente("Camila Casa", ELoja.CASA);

        alvaro.gravarVendasPrimeiraSemna("372,55");
        costa.gravarVendasPrimeiraSemna("4852,23");
        janaina.gravarVendasPrimeiraSemna("7213,25");
        kawan.gravarVendasPrimeiraSemna("24,63");
        lucas.gravarVendasPrimeiraSemna("944,28");
        loja.gravarVendasPrimeiraSemna("25,68");
        loja.gravarVendasPrimeiraSemna("6550,18");
        loja.gravarVendasPrimeiraSemna("24,90");
        nailton.gravarVendasPrimeiraSemna("3830,96");
        pedro.gravarVendasPrimeiraSemna("5060,98");
        samuel.gravarVendasPrimeiraSemna("4920,84");
        thaina.gravarVendasPrimeiraSemna("9119,30");
        vinicius.gravarVendasPrimeiraSemna("7965,80");

        alvaro.gravarVendasSegundaSemana("13,65");
        apoio.gravarVendasSegundaSemana("652,00");
        costa.gravarVendasSegundaSemana("8548,09");
        janaina.gravarVendasSegundaSemana("4823,84");
        lucas.gravarVendasSegundaSemana("1307,38");
        loja.gravarVendasSegundaSemana("5033,24");
        nailton.gravarVendasSegundaSemana("5193,15");
        pedro.gravarVendasSegundaSemana("6638,19");
        kawan.gravarVendasSegundaSemana("0,00");
        samuel.gravarVendasSegundaSemana("4440,35");
        thaina.gravarVendasSegundaSemana("10317,61");
        vinicius.gravarVendasSegundaSemana("6566,38");

        alvaro.gravarVendasTerceiraSemana("190,66");
        costa.gravarVendasTerceiraSemana("6224,35");
        janaina.gravarVendasTerceiraSemana("3127,38");
        lucas.gravarVendasTerceiraSemana("2316,09");
        kawan.gravarVendasTerceiraSemana("0,00");
        loja.gravarVendasTerceiraSemana("2994,44");
        nailton.gravarVendasTerceiraSemana("4499,49");
        pedro.gravarVendasTerceiraSemana("6923,42");
        samuel.gravarVendasTerceiraSemana("3149,20");
        thaina.gravarVendasTerceiraSemana("8534,83");
        vinicius.gravarVendasTerceiraSemana("5399,88");

        alvaro.gravarVendasQuartaSemana("169,61");
        apoio.gravarVendasQuartaSemana("5640,79");
        costa.gravarVendasQuartaSemana("3567,96");
        janaina.gravarVendasQuartaSemana("6400,76");
        lucas.gravarVendasQuartaSemana("1460,66");
        kawan.gravarVendasQuartaSemana("0,00");
        loja.gravarVendasQuartaSemana("3118,92");
        loja.gravarVendasQuartaSemana("208,13");
        nailton.gravarVendasQuartaSemana("2509,41");
        pedro.gravarVendasQuartaSemana("6349,26");
        samuel.gravarVendasQuartaSemana("1839,55");
        thaina.gravarVendasQuartaSemana("7950,85");
        vinicius.gravarVendasQuartaSemana("4807,94");

        alvaro.gravarVendasQuintaSemana("0,00");
        apoio.gravarVendasQuintaSemana("2778,93");
        costa.gravarVendasQuintaSemana("1118,11");
        janaina.gravarVendasQuintaSemana("782,96");
        lucas.gravarVendasQuintaSemana("570,59");
        kawan.gravarVendasQuintaSemana("0,00");
        loja.gravarVendasQuintaSemana("928,32");
        nailton.gravarVendasQuintaSemana("2789,14");
        pedro.gravarVendasQuintaSemana("1300,35");
        samuel.gravarVendasQuintaSemana("672,44");
        thaina.gravarVendasQuintaSemana("3004,87");
        vinicius.gravarVendasQuintaSemana("432,77");

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

        bruna.gravarVendasPrimeiraSemna("6655,56");
        dani.gravarVendasPrimeiraSemna("2683,43");
        isabeleSonho.gravarVendasPrimeiraSemna("6222,45");
        sara.gravarVendasPrimeiraSemna("8721,51");
        camila.gravarVendasPrimeiraSemna("0,00");
        karol.gravarVendasPrimeiraSemna("0,00");
        lojaSonho.gravarVendasPrimeiraSemna("424,33");

        alef.gravarVendasSegundaSemana("0,00");
        bruna.gravarVendasSegundaSemana("10480,52");
        camila.gravarVendasSegundaSemana("0,00");
        dani.gravarVendasSegundaSemana("755,51");
        karol.gravarVendasSegundaSemana("0,00");
        sara.gravarVendasSegundaSemana("8267,67");
        lojaSonho.gravarVendasSegundaSemana("256,48");
        isabeleSonho.gravarVendasSegundaSemana("5270,54");
        valeriaSonho.gravarVendasSegundaSemana("1980,29");

        beatrizSonho.gravarVendasTerceiraSemana("0,00");
        bruna.gravarVendasTerceiraSemana("11284,50");
        dani.gravarVendasTerceiraSemana("224,78");
        lojaSonho.gravarVendasTerceiraSemana("318,12");
        karol.gravarVendasTerceiraSemana("0,00");
        sara.gravarVendasTerceiraSemana("9422,58");
        lojaSonho.gravarVendasTerceiraSemana("0,00");
        isabeleSonho.gravarVendasTerceiraSemana("3682,72");

        bruna.gravarVendasQuartaSemana("7800,87");
        dani.gravarVendasQuartaSemana("624,69");
        karol.gravarVendasQuartaSemana("0,00");
        sara.gravarVendasQuartaSemana("8916,49");
        lojaSonho.gravarVendasQuartaSemana("0,00");
        isabeleSonho.gravarVendasQuartaSemana("4934,17");

        bruna.gravarVendasQuintaSemana("3774,32");
        dani.gravarVendasQuintaSemana("210,88");
        karol.gravarVendasQuintaSemana("0,00");
        sara.gravarVendasQuintaSemana("5385,13");
        lojaSonho.gravarVendasQuintaSemana("0,00");
        isabeleSonho.gravarVendasQuintaSemana("1111,69");

        // CASA DO BEBÊ
        beatrizCasa.gravarVendasPrimeiraSemna("10241,83");
        juliana.gravarVendasPrimeiraSemna("3340,10");
        lojaCasa.gravarVendasPrimeiraSemna("121,85");
        lojaCasa.gravarVendasPrimeiraSemna("405,00");
        valeria.gravarVendasPrimeiraSemna("4539,85");
        camilaCasa.gravarVendasPrimeiraSemna("0,00");

        beatrizCasa.gravarVendasSegundaSemana("6415,62");
        camilaCasa.gravarVendasSegundaSemana("0,00");
        camilaCasa.gravarVendasSegundaSemana("0,00");
        juliana.gravarVendasSegundaSemana("3924,69");
        lojaCasa.gravarVendasSegundaSemana("444,99");
        lojaCasa.gravarVendasSegundaSemana("461,00");
        valeria.gravarVendasSegundaSemana("12377,79");
        valeria.gravarVendasSegundaSemana("1980,29");

        beatrizCasa.gravarVendasTerceiraSemana("7738,66");
        beatrizCasa.gravarVendasTerceiraSemana("0,00");
        camilaCasa.gravarVendasTerceiraSemana("0,00");
        juliana.gravarVendasTerceiraSemana("1955,03");
        lojaCasa.gravarVendasTerceiraSemana("9,98");
        lojaCasa.gravarVendasTerceiraSemana("600,00");
        valeria.gravarVendasTerceiraSemana("4397,31");

        beatrizCasa.gravarVendasQuartaSemana("3683,65");
        camilaCasa.gravarVendasQuartaSemana("0,00");
        juliana.gravarVendasQuartaSemana("3560,07");
        lojaCasa.gravarVendasQuartaSemana("23,99");
        lojaCasa.gravarVendasQuartaSemana("396,00");
        valeria.gravarVendasQuartaSemana("2865,05");

        beatrizCasa.gravarVendasQuintaSemana("859,47");
        camilaCasa.gravarVendasQuintaSemana("0,00");
        juliana.gravarVendasQuintaSemana("1025,91");
        lojaCasa.gravarVendasQuintaSemana("142,00");
        valeria.gravarVendasQuintaSemana("1052,39");


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
