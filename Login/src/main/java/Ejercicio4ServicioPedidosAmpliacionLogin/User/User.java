package Ejercicio4ServicioPedidosAmpliacionLogin.User;


import java.time.LocalDate;

import lombok.Data;

@Data
public class User {
	
	private Long id;
	private String username;
	private String password;
	private String email;
	private LocalDate regDate;
	private LocalDate lastLoginDate;
	

	public User(Long id, String username, String password, String email, LocalDate regDate, LocalDate lastLoginDate) {

		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.regDate = regDate;
		this.lastLoginDate = lastLoginDate;
	}


	public User() {
	
	}
	
	
	
	
}
