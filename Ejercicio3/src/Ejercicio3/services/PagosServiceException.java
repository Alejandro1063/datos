package Ejercicio3.services;

public class PagosServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6289807670116989546L;

	public PagosServiceException() {
	}

	public PagosServiceException(String message) {
		super(message);

	}

	public PagosServiceException(Throwable cause) {
		super(cause);

	}

	public PagosServiceException(String message, Throwable cause) {
		super(message, cause);

	}

	public PagosServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
