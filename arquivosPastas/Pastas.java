package arquivosPastas;

import java.io.File;
import java.io.IOException;

public class Pastas {
    public static void main(String[] args) throws IOException{
        //Determinando os nomes das pastas
        String subJoao[] = {"Ana", "Lucas", "Anthony"};
        String subLucas[] = {"Maria", "Pedro", "Ricardo"};

        //Determinando variáveis para armazenar os caminhos das pastas e subpastas
        String path, pathLucas, pathAnthony;
        
        //Criar a pasta principal (João)
        File joao = new File("João");

        if(!joao.exists()) {
            joao.mkdir();
        }

        //Armazenar o caminho da pasta principal para criar as subpastas posteriormente
        path = joao.getAbsolutePath();

        for(int i = 0; i < subJoao.length; i++) {
            //Criar cada subpasta
            File pastaJoao = new File(path, subJoao[i]);

            if(!pastaJoao.exists()) {
                pastaJoao.mkdir();
            }

            if(subJoao[i] == "Lucas") {
                //Armazenar o caminho da subpasta "Lucas" para criar novas pastas dentro dessa pasta
                pathLucas = pastaJoao.getAbsolutePath();

                for(int j = 0; j < subLucas.length; j++) {
                    //Criar as subpastas da pasta "Lucas"
                    File pastaLucas = new File(pathLucas, subLucas[j]);

                    if(!pastaLucas.exists()) {
                        pastaLucas.mkdir();
                    }

                    if(subLucas[i] == "Pedro") {
                        //Criar a subpasta da pasta "Pedro"
                        File luiz = new File(pathLucas + "\\Pedro", "Luiz");

                        if(!luiz.exists()) {
                            luiz.mkdir();
                        }
                    }
                }
            }

            if(subJoao[i] == "Anthony") {
                //Armazenar o caminho da subpasta "Anthony" para criar novas pastas dentro dessa pasta
                pathAnthony = pastaJoao.getAbsolutePath();

                File felipe = new File(pathAnthony, "Felipe");

                if(!felipe.exists()) {
                    felipe.mkdir();
                }

                //Criar a subpasta da pasta "Felipe"
                File carol = new File(pathAnthony + "\\" + "Felipe", "Carol");

                if(!carol.exists()) {
                    carol.mkdir();
                }
            }
        }
    }
}