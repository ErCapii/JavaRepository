package ServicioPeliculas.Service;

public class PeliculaServiceException extends Exception {

	public PeliculaServiceException() {
	}

	public PeliculaServiceException(String message) {
		super(message);

	}

	public PeliculaServiceException(Throwable cause) {
		super(cause);

	}

	public PeliculaServiceException(String message, Throwable cause) {
		super(message, cause);

	}

	public PeliculaServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
