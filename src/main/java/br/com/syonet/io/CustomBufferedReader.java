package br.com.syonet.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.com.syonet.CustomFileReader;

public class CustomBufferedReader extends CustomFileReader {

  public CustomBufferedReader(String filePath) {
    super(filePath);
  }
  public void execute() {
    try (BufferedReader reader = new BufferedReader(new FileReader(this.filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
    }
  }
}
