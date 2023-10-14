package proyectoFCT.servicio;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import proyectoFCT.dao.FechaDao;
import proyectoFCT.exception.EvaluacionException;
import proyectoFCT.exception.FechaServiceException;
import proyectoFCT.modelo.Fecha;

public class FechaService {

	
	private OpenConnection conn;
	private Integer anho;
	private Integer evaluacion;

	public FechaService() {
		conn = new OpenConnection();

	}

	// Método que devuelve una lista de fechas filtradas por la evaluación actual
	public List<Fecha> consultarFechasActuales() throws EvaluacionException, FechaServiceException{
		Connection con = null;
				
		try {	
		con = conn.getConection();
		List<Fecha> listaFechas = new ArrayList<Fecha>();
		FechaDao Fechas = new FechaDao();
		anho = LocalDate.now().getYear();
		if(LocalDate.now().getMonthValue() >= 9 || LocalDate.now().getMonthValue()<=11) {
			evaluacion=1;
		}
		else if(LocalDate.now().getMonthValue() >= 12 || LocalDate.now().getMonthValue()<=3) {
			evaluacion=2;
		}
		else if(LocalDate.now().getMonthValue() >= 4 || LocalDate.now().getMonthValue()<=6) {
			evaluacion=3;
		}
		else {
			throw new EvaluacionException();
		}
		
	
		listaFechas = Fechas.consultarFecha(con, anho, evaluacion);
		
		return listaFechas;
		
	} catch (SQLException e) {
		System.out.println("Error en la base de datos" + e.getMessage());
		e.printStackTrace();
		throw new FechaServiceException();
	}

	finally {
		try {
			 con.close();
		} catch (Exception e) {
		}

	}
}
	}
