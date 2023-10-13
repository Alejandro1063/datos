package ceu_fct.servicio;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ceu_fct.dao.FechaDao;
import ceu_fct.exception.EvaluacionException;
import ceu_fct.exception.FechaServiceException;
import ceu_fct.modelo.Fecha;

public class FechaService {

	
	private OpenConnection conn;
	private Integer anho;
	private Integer evaluacion;

	public FechaService() {
		conn = new OpenConnection();

	}
	
	public List<Fecha> consultarFechasActuales() throws EvaluacionException, FechaServiceException{
		Connection con = null;
				
		try {		
		List<Fecha> listaFechas = new ArrayList<Fecha>();
		FechaDao Fechas = new FechaDao();
		anho = LocalDate.now().getYear();
		if(LocalDate.now().getMonthValue() >= 9 || LocalDate.now().getMonthValue()<=11) {
			evaluacion=1;
		}
		else if(LocalDate.now().getMonthValue() >= 12 || LocalDate.now().getMonthValue()<=2) {
			evaluacion=2;
		}
		else if(LocalDate.now().getMonthValue() >= 3 || LocalDate.now().getMonthValue()<=6) {
			evaluacion=3;
		}
		else {
			throw new EvaluacionException();
		}
		
		con = conn.getConection();
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
