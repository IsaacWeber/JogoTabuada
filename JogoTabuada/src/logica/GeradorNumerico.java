package logica;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeradorNumerico {
    private int limInferior;
    private int limSuperior;
    private List<Integer> valoresGerados;
    private SecureRandom secureRandom;

    public GeradorNumerico() {
        limInferior = 0;
        limSuperior = 10;
        secureRandom = new SecureRandom();
        valoresGerados = new ArrayList<>();
    }

    public GeradorNumerico(int li, int ls) {
        limInferior = li;
        limSuperior = ls;
        secureRandom = new SecureRandom();
        valoresGerados = new ArrayList<>();
    }

    public List<Integer> gerarResultados(int a, int b, int quantidade) {
        List<Integer> resultados = new ArrayList<>();
        int r = a * b;
        resultados.add(r);
        int g = 0;

        if (r <= quantidade) {
            while(resultados.size() < quantidade) {
                g = secureRandom.nextInt(quantidade);
                if(!resultados.contains(g)) resultados.add(g);
            }
        } else {
            int indicadorAB; // indicadorAB = 0 (A) " = 1 (B); operacao = 0 (A) " = 1 (B)
            int operacao;

            while (resultados.size() < quantidade) {
                indicadorAB = secureRandom.nextInt(2);
                operacao = secureRandom.nextInt(2);

                g = indicadorAB == 0 ? 1 + secureRandom.nextInt(a) : 1 + secureRandom.nextInt(b);
                g = operacao == 0 ? r - g : r + g;

                if(!resultados.contains(g)) resultados.add(g);
            }
        }

        Collections.shuffle(resultados);
        return resultados;
    }

    public int gerarNumeroSemRepeticao() {
        int valor = 0;
        while(true) {
            valor = limInferior + secureRandom.nextInt(limSuperior - limInferior + 1);
            if (!valoresGerados.contains(valor)) {
                valoresGerados.add(valor);
                break;
            } else if(valoresGerados.size() == (limSuperior - limInferior + 1)) {
                valoresGerados.clear();
                valoresGerados.add(valor);
                break;
            }
        }

        return valor;
    }

    public static void main(String[] args) {

        var g = new GeradorNumerico(0, 2);
       /* for(int i = 0; i < 10; ++i) {
            System.out.println(g.gerarNumeroSemRepeticao());
        }
        */
        for(int i = 0; i < 100; ++i)
                System.out.println(g.gerarResultados(10, 2, 5));

    }
}
