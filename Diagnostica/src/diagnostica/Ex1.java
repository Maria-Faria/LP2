/*Crie um programa em que solicita ao usuário o valor de N e, posteriormente os N números que devem ser armazenados em um vetor. 
Em um segundo momento, exiba o vetor na ordem em que os elementos foram digitados e em ordem inversa.*/

package diagnostica;

import javax.swing.JOptionPane;

public class Ex1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade de valores do vetor", "Tamanho do vetor", JOptionPane.QUESTION_MESSAGE));

        int vetor[] = new int[n];

        armazenar(vetor);

        System.out.println("--------- Vetor gerado (na ordem) ----------");
        exibirOrdem(vetor);

        System.out.println("---------- Vetor gerado (na ordem inversa) ---------");
        ordemInversa(vetor);
    }

    public static void armazenar(int vetor[]) {

        for(int i = 0; i < vetor.length; i++) {
            vetor[i] = Integer.parseInt(JOptionPane.showInputDialog(null, String.format("Informe o %dº elemento do vetor", (i + 1)), "Valores", JOptionPane.INFORMATION_MESSAGE));    
        }
    }

    public static void exibirOrdem(int vetor[]) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }

    public static void ordemInversa(int vetor[]) {
        for(int i = (vetor.length - 1); i >= 0; i--) {
            System.out.println(vetor[i]);
        }
    }
}