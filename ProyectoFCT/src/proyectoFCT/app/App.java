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
	try { //testeo para comprobar si existe el usuario en la bbdd
		userService.loginUsuario("Ale@ceu.es", "1234");
		System.out.println("Login correcto");
	} catch (UsuarioNoExisteException e) { //excepción para mostrar si el usuario no existe
		e.printStackTrace();
	} catch (AutenticationException e) { // excepción de autenticación por si la contraseña no corresponde
		e.printStackTrace();
	} catch (UsuarioServiceException e) { // excepción para cualquier otro tipo de error
		e.printStackTrace();
	}
	
	*/
	/*try { // testeo para dar de alta un usuario en la bbdd

		user.setActivo(true);
		user.setApellidos("Rod Hir");
		user.setCiclo("DAM");
		user.setEmail("Ale@ceu.es");
		user.setId_usuario(1L);
		user.setNombre("Ale");
		user.setPassword("1234");
		System.out.println(user);
		userService.altaUsuario(user);
	} catch (UsuarioServiceException e) { // excepción creada por si el usuario ya existe en la bbdd
		e.printStackTrace();
	}
	*/
	
	/*
		try { // testeo para recoger las fechas según la evaluación actual (la evalucación se asigna automáticamente dependiendo del sysdate)
			System.out.println(fech.consultarFechasActuales());
		} catch (EvaluacionException e) { // Excepción que se lanza si la fecha actual está fuera de cualquier evaluación
			e.printStackTrace();
		} catch (FechaServiceException e) { // Excepción lanzada cuando hay algún error en la bbdd
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
		regi.insertarRegistro(reg); // testeo para insertar registros nuevos en la bbdd
	} catch (RegistroServiceException e) { // Excepción lanzada cuando ya existe un registro en la bbdd con los mismos parámetros que la que se pretende insertar
		
		e.printStackTrace();
	}
	*/
	/*
	try {
		System.out.println(regi.consultarRegistrosUsuarios(3L)); // testeo para recibir una lista de registros filtrado por el id del usuario
	} catch (RegistroServiceException e) { // Excepción lanzada cuando hay algún error en la bbdd
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (UsuarioNoExisteException e) { // Excepción lanzada cuando no existe el id del usuario en la bbdd
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	*/
}

}
