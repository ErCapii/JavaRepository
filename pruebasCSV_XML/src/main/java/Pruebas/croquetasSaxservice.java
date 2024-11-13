package Pruebas;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;

public class croquetasSaxservice {

    public List<Croqueta> leerCroquetas(String nombreFichero) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            croquetasHandler handler = new croquetasHandler();
            File file = new File(nombreFichero);
            saxParser.parse(file, handler);
            return handler.getCroquetas();
        } catch (Exception e) {
            throw new RuntimeException("error extrayendo el xml ", e);
        }

    }
}
