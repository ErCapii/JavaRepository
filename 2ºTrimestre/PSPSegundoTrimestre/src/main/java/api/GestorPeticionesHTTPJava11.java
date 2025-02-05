package api;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class GestorPeticionesHTTPJava11 {
    public int almacenarPagina(String esquema, String servidor, String recurso, String path) {
        try {
            recurso = URLEncoder.encode(recurso, StandardCharsets.UTF_8);
            String direccionCompleta = esquema + servidor + recurso;

            HttpClient httpClient = HttpClient
            	.newBuilder()
            	.version(Version.HTTP_1_1) 
            	.followRedirects(HttpClient.Redirect.NORMAL) 
            	.build();
            HttpRequest request = HttpRequest.newBuilder()
            		.GET() 
                    .uri(URI.create(direccionCompleta)) 
                    .headers("Content-Type", "text/plain") 
                    .setHeader("User-Agent", "Moxilla/5.0") 
                    .build();
            
            HttpResponse<Path> response = httpClient.send(request, 
            		HttpResponse.BodyHandlers.ofFile(Path.of(path)));
            System.out.println(response.body());

            return response.statusCode();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args) {
        GestorPeticionesHTTPJava11 gestor = new GestorPeticionesHTTPJava11();
        int estado = gestor.almacenarPagina("https://", "pokeapi.co/api/v2/pokemon/", "ditto", "pokemon.json");
        System.out.println("Código de estado HTTP: " + estado);
    }
}