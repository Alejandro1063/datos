package ceu_fct.servicio;

public class AutenticationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -41346960570650795L;

	public AutenticationException() {
	}

	public AutenticationException(String message) {
		super(message);

	}

	public AutenticationException(Throwable cause) {
		super(cause);

	}

	public AutenticationException(String message, Throwable cause) {
		super(message, cause);

	}

	public AutenticationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
