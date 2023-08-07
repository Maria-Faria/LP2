/*Crie um programa em JAVA que solicita ao usuário o valor de N e, posteriormente, alimente o vetor com valores aleatórios entre 0 e M 
(M também é informado pelo usuário). Exiba o vetor gerado.*/

package diagnostica;

import javax.swing.JOptionPane;

public class Ex2 {
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade de elementos do vetor", "Tamanho do vetor", JOptionPane.WARNING_MESSAGE));

        int vetor[] = new int[n];

        int m = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o valor limite para geração de números aleatórios", "Valor limite", JOptionPane.QUESTION_MESSAGE));

        armazenar(vetor, m);

        System.out.println("------- Vetor gerado ---------");
        exibir(vetor);
    }

    public static void armazenar(int vetor[], int m) {
        for(int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * m);
        }
    }

    public static void exibir(int vetor[]) {
        for(int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }
}
