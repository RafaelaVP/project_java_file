package br.com.syonet;
import br.com.syonet.io.CustomBufferedReader;


import java.util.List;

public class Main {

    public static void main(String[] args) {

        FilialCSVReader filialCSVReader = new FilialCSVReader("arquivo_fornecido.csv");

        List<Filial> filiais = filialCSVReader.lerFiliais();

        if (filiais.isEmpty()) {
            System.out.println("Nenhuma filial foi encontrada no arquivo CSV.");
            return;
        }

        Filial filialComMaiorMedia = filiais.stream()
            .max((f1, f2) -> Double.compare(f1.calcularMediaMensal(), f2.calcularMediaMensal()))
            .orElse(null);

        if (filialComMaiorMedia != null) {
            System.out.println("A filial com a maior média de visitas é: " + filialComMaiorMedia.getNome() +
                    " com uma média de " + filialComMaiorMedia.calcularMediaMensal() + " visitas mensais.");
        } else {
            System.out.println("Não foi possível determinar a filial com a maior média de visitas.");
        }
    }
}

