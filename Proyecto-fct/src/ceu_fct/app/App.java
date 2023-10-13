package ceu_fct.app;

import ceu_fct.modelo.Registro;
import ceu_fct.modelo.Usuario;
import ceu_fct.servicio.FechaService;
import ceu_fct.servicio.RegistroService;
import ceu_fct.servicio.UsuarioService;


public class App {

public static void main(String[] args) {
	Usuario user = new Usuario();
	UsuarioService userService = new UsuarioService();
	FechaService fech = new FechaService();
	Registro reg = new Registro();
	RegistroService regi = new RegistroService();
	
	
	/*try {
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
	reg.
/*
		fech.consultarFechasActuales();
	} catch (EvaluacionException e) {
		e.printStackTrace();
	} catch (FechaServiceException e) {
		e.printStackTrace();
	}
	*/
	
}

}
