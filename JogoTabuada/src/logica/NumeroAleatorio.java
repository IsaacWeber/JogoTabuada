package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NumeroAleatorio {

    static Scanner input = new Scanner(System.in);

    private List<Integer> numeros;

    public NumeroAleatorio() {
        reiniciarContagem();
    }

    private void reiniciarContagem() {
        numeros = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numeros.add(i);
        }
        Collections.shuffle(numeros);
    }

    public int gerarNumeroAleatorio() {
        if (numeros.isEmpty()) {
            reiniciarContagem();
        }
        return numeros.remove(0);
    }

    public void multiplicacao(int num) {
        NumeroAleatorio gerador = new NumeroAleatorio();

        int acertos = 0, erros = 0;

        for (int i = 1; i <= 10; i++) {
            int numero = gerador.gerarNumeroAleatorio();

            System.out.println("Qual o resultado da multiplicação abaixo? ");
            int numeroAleatorio = numero;
            System.out.println(num + " X " + numeroAleatorio);
            int multiplicação = num * numeroAleatorio;
            System.out.print("Sua resposta: ");
            int numResposta = input.nextInt();

            if (numResposta == multiplicação) {
                System.out.println("Correto, você acertou! Vamos para o próximo!\n");
                acertos++;
            } else {
                System.out.println("Incorreto! Vamos para o próximo.\n");
                erros++;
            }

        }
        System.out.printf("Quantidade de acertos: %d\n", acertos);
        System.out.printf("Quantidade de erros: %d\n", erros);
    }

    public static void main(String[] args) {
        NumeroAleatorio numeroAleatorio = new NumeroAleatorio();
        String escolha;
        do {
            System.out.println("Digite um numero qualquer.");
            int num = 2;
            // Rodando de 1 a 10
            numeroAleatorio.multiplicacao(num);

            System.out.println("Deseja recomeçar? S/N");
            escolha = input.next();

            if (escolha.equalsIgnoreCase("S")) {
                System.out.println("\nOK! Recomeçando.\n");
            } else {
                System.out.println("Obrigado por jogar!");
                break;
            }

        } while (escolha != "S");
        /*
         * Reiniciando e rodando novamente
         * gerador.reiniciarContagem();
         * for (int i = 1; i <= 10; i++) {
         * int numero = gerador.gerarNumeroAleatorio();
         * System.out.println("Número gerado: " + numero);
         * }
         */
    }
}