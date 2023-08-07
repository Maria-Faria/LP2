/*Crie um programa em JAVA que faça a leitura de um arquivo de texto contendo um número inteiro em cada linha onde: 
O número da primeira linha é o valor de N e os números subsequentes são a sequência numérica de interesse. 
Armazene os valores lidos em um vetor e exiba-o. Aproveite sua implementação do Exercício 1 e escreva em outro arquivo a sequência numérica em ordem inversa.*/

package diagnostica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Ex4 {
    public static void main(String[] args) {
        String arq = "";
        String linha = "";

        JOptionPane.showMessageDialog(null, "Escolha o arquivo para leitura do vetor", "Vetor", JOptionPane.INFORMATION_MESSAGE);

        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showSaveDialog(chooser);

        try {
            lerArquivo(chooser, returnVal, arq, linha);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void lerArquivo(JFileChooser chooser, int returnVal, String arq, String linha) throws IOException{
        FileFilter filtro = new FileNameExtensionFilter("Só TXT ou DOC", "txt", "doc");
        chooser.addChoosableFileFilter(filtro);

        returnVal = chooser.showOpenDialog(chooser);

        if(returnVal == JFileChooser.APPROVE_OPTION) {
            arq = chooser.getSelectedFile().getAbsolutePath();
        }

        BufferedReader ler = new BufferedReader(new FileReader(arq));
        linha = ler.readLine();

        int n = Integer.parseInt(linha);

        int vetor[] = new int[n];
        int i = 0;

        while(linha != null) {
            linha = ler.readLine();

            if(linha == null) {
                break;
            }

            vetor[i] = Integer.parseInt(linha);
            i++;
        }

        ler.close();

        System.out.println("------ Vetor gerado ------");
        exibir(vetor);

        System.out.println("------ Vetor em ordem inversa ------");
        escreverArquivo(returnVal, arq, vetor);
    }

    public static void exibir(int vetor[]) {
        for(int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }

    public static void escreverArquivo(int returnVal, String arq, int vetor[]) throws IOException{
        JOptionPane.showMessageDialog(null, "Escolha o arquivo para escrever o vetor em ordem inversa", "Vetor Inverso", JOptionPane.INFORMATION_MESSAGE);
        
        JFileChooser chooser = new JFileChooser();
        returnVal = chooser.showSaveDialog(chooser);

        if(returnVal == JFileChooser.APPROVE_OPTION) {
            arq = chooser.getSelectedFile().getAbsolutePath();
        }

        System.out.println("Escrevendo no arquivo " + arq + "\n");
        BufferedWriter escrever = new BufferedWriter(new FileWriter(arq, false));

        for(int i = (vetor.length - 1); i >= 0; i--) {
            escrever.append(vetor[i] + "\n");
            System.out.println(vetor[i]);
        }

        escrever.close();
    } 
}
