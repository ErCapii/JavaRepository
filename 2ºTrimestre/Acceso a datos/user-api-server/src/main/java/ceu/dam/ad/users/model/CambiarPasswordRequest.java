package ceu.dam.ad.users.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CambiarPasswordRequest {

	
	@NotBlank(message = "La contraseña es oblicatoria")
	@Size(max = 100)
	private String oldPass;
	@NotBlank(message = "La contraseña es oblicatoria")
	@Size(max = 100)
	private String newPass;
	
	public CambiarPasswordRequest(String oldPass, String newPass) {
		
		this.oldPass = oldPass;
		this.newPass = newPass;
	}

}
