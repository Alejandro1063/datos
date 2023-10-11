package ejemploJdbc1.servicios;

import java.sql.SQLException;

public class ActoresServiceException extends SQLException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActoresServiceException() {
		super();
	}

	public ActoresServiceException(String reason, String sqlState, int vendorCode, Throwable cause) {
		super(reason, sqlState, vendorCode, cause);
	}

	public ActoresServiceException(String reason, String SQLState, int vendorCode) {
		super(reason, SQLState, vendorCode);
	}

	public ActoresServiceException(String reason, String sqlState, Throwable cause) {
		super(reason, sqlState, cause);
	}

	public ActoresServiceException(String reason, String SQLState) {
		super(reason, SQLState);
	}

	public ActoresServiceException(String reason, Throwable cause) {
		super(reason, cause);
	}

	public ActoresServiceException(String reason) {
		super(reason);
	}

	public ActoresServiceException(Throwable cause) {
		super(cause);
	}

}
