package ceu.dam.ad.ejerciciosTema3.csv.ejercicio01;

public class CsvPeliculasException extends Exception {
    public CsvPeliculasException() {
        super("Error al escribir el fichero CSV");
    }

    public CsvPeliculasException(String message) {
        super(message);
    }

    public CsvPeliculasException(String message, Throwable cause) {
        super(message, cause);
    }

    public CsvPeliculasException(Throwable cause) {
        super(cause);
    }

    public CsvPeliculasException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    private static final long serialVersionUID = 1L;


}
