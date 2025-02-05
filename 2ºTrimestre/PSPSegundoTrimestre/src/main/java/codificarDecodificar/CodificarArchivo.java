package codificarDecodificar;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;


public class CodificarArchivo {
    public static void main(String[] args) {
        String filePath = "C:/Users/adominguez5871/Documents/deco.txt"; 
        String outputPath = "C:/Users/adominguez5871/Documents/archivoCodificado.txt";
        String outputPathDeco = "C:/Users/adominguez5871/Documents/archivoDodificado.txt";

        try {
            Path path = Paths.get(filePath);
            byte[] fileBytes = Files.readAllBytes(path);
            String encodedString = Base64.getEncoder().encodeToString(fileBytes);
            Path output = Paths.get(outputPath);
            Files.write(output, encodedString.getBytes());
            
            byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
            Path outputDecode = Paths.get(outputPathDeco);
            Files.write(outputDecode, decodedBytes);

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

