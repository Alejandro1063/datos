package proyectoFCT.app;

import java.math.BigDecimal;
import java.time.LocalDate;

import proyectoFCT.exception.AutenticationException;
import proyectoFCT.exception.EvaluacionException;
import proyectoFCT.exception.FechaServiceException;
import proyectoFCT.exception.RegistroServiceException;
import proyectoFCT.exception.UsuarioNoExisteException;
import proyectoFCT.exception.UsuarioServiceException;
import proyectoFCT.modelo.Registro;
import proyectoFCT.modelo.Usuario;
import proyectoFCT.servicio.FechaService;
import proyectoFCT.servicio.RegistroService;
import proyectoFCT.servicio.UsuarioService;

public class App {

public static void main(String[] args) {
	Usuario user = new Usuario();
	UsuarioService userService = new UsuarioService();
	FechaService fech = new FechaService();
	Registro reg = new Registro();
	RegistroService regi = new RegistroService();
	
	/*
	try {
		userService.loginUsuario("Ale@ceu.es", "1234");
		System.out.println("Login correcto");
	} catch (UsuarioNoExisteException e) {
		e.printStackTrace();
	} catch (AutenticationException e) {
		e.printStackTrace();
	} catch (UsuarioServiceException e) {
		e.printStackTrace();
	}
	
	*/
	/*try {

		user.setActivo(true);
		user.setApellidos("Rod Hir");
		user.setCiclo("DAM");
		user.setEmail("Ale@ceu.es");
		user.setId_usuario(1L);
		user.setNombre("Ale");
		user.setPassword("1234");
		System.out.println(user);
		userService.altaUsuario(user);
	} catch (UsuarioServiceException e) {
		e.printStackTrace();
	}
	*/
	
	/*
		try {
			System.out.println(fech.consultarFechasActuales());
		} catch (EvaluacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FechaServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	*/
	/*
	reg.setDescripcion("Hoy he destruido la bbdd de la empresa");
	reg.setFecha(LocalDate.now());
	reg.setIdRegistro(1L);
	reg.setIdUsuario(3L);
	reg.setNumHoras(new BigDecimal(9));
	
	try {
		regi.insertarRegistro(reg);
	} catch (RegistroServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	*/
	/*
	try {
		System.out.println(regi.consultarRegistrosUsuarios(3L));
	} catch (RegistroServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (UsuarioNoExisteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	*/
}

}