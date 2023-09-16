package sequenciasNumericas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Numeros {
    public static void main(String[] args) {
        //Determinando os nomes das pastas
        String dir[] = {"100", "1000", "10000", "50000", "100000"};

        //Determinando variável para armazenar o caminho das pastas
        String path;
        int inicio, fim = 0;

        for(int i = 0; i < dir.length; i++) {
            //Determinando valores de início e fim para o arq1 de cada pasta
            inicio = 0; //Sempre iniciando em zero
            fim = Integer.parseInt(dir[i]) - 1; //Sempre terminando no valor da pasta - 1 (ex: pasta 100 = arq 1 terá valores de 0 a 99)

            path = criarPastas(dir, i);
            System.out.println(path);
            System.out.println("-----------------");
            
            try {
                criarArquivos(path, inicio, fim, Integer.parseInt(dir[i]));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String criarPastas(String[] dir, int i) {
        //Criar pastas
        File folder =  new File(dir[i]);

        if(!folder.exists()) {
            folder.mkdir();
        }

        return folder.getAbsolutePath();
    }

    public static void criarArquivos(String path, int inicio, int fim, int valor) throws IOException{
        //Criar 10 arquivos dentros de cada pasta
        for(int i = 1; i <= 10; i++) {
            File file = new File(path + "\\arq" + i + ".txt");

            file.createNewFile();
            System.out.println(file + " criado");

            escrever(file, inicio, fim);
            inicio = fim + 1;
            fim = inicio + (valor - 1);
        }
    }

    public static void escrever(File file, int inicio, int fim) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        //Preenchendo os 10 arquivos com valores aleatórios dentro do intervalo determinado
        for(int j = inicio; j <= fim; j++) {
            int x = inicio + (int) (Math.random() * (fim - inicio + 1));
            writer.append(x + "\n");
        }

        writer.close();
    }
}