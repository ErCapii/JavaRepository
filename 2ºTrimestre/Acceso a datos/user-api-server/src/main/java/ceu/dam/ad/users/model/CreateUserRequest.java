package ceu.dam.ad.users.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateUserRequest {

	@NotNull(message = "El nombre es obligatorio")
	@Size(min = 3, max = 50)
	private String username;
	@NotNull(message = "El email es obligatorio")
	@Size(min = 3, max = 50)
	private String email;
	@NotNull(message = "La password es obligatoria")
	@Size(min = 8, max = 100)
	private String password;

}
