/*Crie um método chamado Insere_Exclusivo(int vet[], int N) que alimenta um vetor de N elementos com valores aleatórios entre 1 e N sem que ocorram números repetidos. 
Exiba o vetor gerado.*/

package diagnostica;

import javax.swing.JOptionPane;

public class Ex3 {
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade de elementos do vetor", "Tamanho do vetor", JOptionPane.INFORMATION_MESSAGE));

        int vetor[] = new int[n];

        insereExclusivo(vetor, n);

        System.out.println("-------- Vetor gerado -------");
        exibir(vetor);
    }

    public static void insereExclusivo(int vetor[], int n) {
        int x;

        for(int i = 0; i < n; i++) {
            x = (int) (Math.random() * n) + 1;

            while(existe(vetor, x)) {
                x = (int) (Math.random() * n) + 1;
            }

            vetor[i] = x;
        }
    }

    public static boolean existe(int vetor[], int x) {
        for(int i = 0; i < vetor.length; i++) {
            if(x == vetor[i]) {
                return true;
            }
        }

        return false;
    }

    public static void exibir(int vetor[]) {
        for(int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }
}
