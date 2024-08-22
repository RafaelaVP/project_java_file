package br.com.syonet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilialCSVReader {
    private String filePath;

    public FilialCSVReader(String filePath) {
        this.filePath = filePath;
    }
    public List<Filial> lerFiliais() {
    List<Filial> filiais = new ArrayList<>();
    
    Map<String, Integer> mesParaNumero = new HashMap<>();
    mesParaNumero.put("JANUARY", 1);
    mesParaNumero.put("FEBRUARY", 2);
    mesParaNumero.put("MARCH", 3);
    mesParaNumero.put("APRIL", 4);
    mesParaNumero.put("MAY", 5);
    mesParaNumero.put("JUNE", 6);
    mesParaNumero.put("JULY", 7);
    mesParaNumero.put("AUGUST", 8);
    mesParaNumero.put("SEPTEMBER", 9);
    mesParaNumero.put("OCTOBER", 10);
    mesParaNumero.put("NOVEMBER", 11);
    mesParaNumero.put("DECEMBER", 12);

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] campos = line.split(",");
            String nome = campos[0];
            String endereco = campos[1];
            String cidade = campos[2];
            String codigoPostal = campos[3];
            List<Integer> visitasMensais = new ArrayList<>();
            
            for (int i = 4; i <= 15; i++) {
                String valor = campos[i].toUpperCase();
                if (mesParaNumero.containsKey(valor)) {
                    visitasMensais.add(mesParaNumero.get(valor));
                } else {
                    visitasMensais.add(Integer.parseInt(valor));
                }
            }
            
            String geolocalizacao = campos[16];
            Filial filial = new Filial(nome, endereco, cidade, codigoPostal, visitasMensais, geolocalizacao);
            filiais.add(filial);
        }
    } catch (IOException e) {
        e.printStackTrace();
    } catch (NumberFormatException e) {
        System.err.println("Erro ao converter uma string para número: " + e.getMessage());
    }
    return filiais;
}
}
