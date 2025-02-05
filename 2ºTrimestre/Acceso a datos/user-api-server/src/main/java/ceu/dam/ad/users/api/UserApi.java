package ceu.dam.ad.users.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.users.model.CambiarPasswordRequest;
import ceu.dam.ad.users.model.CreateUserRequest;
import ceu.dam.ad.users.model.User;
import ceu.dam.ad.users.service.DuplicateUserException;
import ceu.dam.ad.users.service.UserException;
import ceu.dam.ad.users.service.UserNotFoundException;
import ceu.dam.ad.users.service.UserService;
import ceu.dam.ad.users.service.UserUnauthorizedException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@SecurityRequirement(name = "Authorization")
public class UserApi {
	@Autowired
	private UserService service;
	
	@Operation(summary = "Crear un nuevo usuario", description = "Permite crear un nuevo usuario")
	@PostMapping("/usuario")
	public User crearUsario(@Valid @RequestBody CreateUserRequest request) throws DuplicateUserException, UserException {
		User user = new User();
		ModelMapper mapper = new ModelMapper(); 
		mapper.map(request, user);
		return service.createUser(user);
	}
	@Operation(summary = "Cambiar contraseña", description = "Permite cambiar la contraseña del usuario pasandole su id, antigua y nueva contraseña")
	@PutMapping("/usuario/{idUser}")
	public void cambiarPassword(@Valid @PathVariable Long idUser,@Valid @RequestBody CambiarPasswordRequest pass ) throws UserNotFoundException, UserUnauthorizedException, UserException {
		System.out.println("entra");
		service.changePassword(idUser, pass.getOldPass(), pass.getNewPass());
	}
	@Operation(summary = "Iniciar sesion ", description = "Permite iniciar sesion medienate un usuario y un password")
	@GetMapping("/usuario")
	public User inicarSesion(@RequestParam String login,@RequestParam String password) throws UserNotFoundException, UserUnauthorizedException, UserException {
		return service.login(login, password);
	}
	@Operation(summary = "Consulta un usario", description = "Permite consultar un usuario mediante una id")
	@GetMapping("/usuario/{id}")
	public User consultarUser(@PathVariable Long id) throws UserNotFoundException, UserException {
		return  service.getUser(id);
	}
	
}
