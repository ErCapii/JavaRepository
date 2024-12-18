package ceu.dam.ad.tema3.ejercicios.ejercicio05.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "login")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Long id;
	@Column(name = "id_user")
	private String username;
	private String email;
	private String password;
	private LocalDate createdDate;
	private LocalDate lastLoginDate;
	
	
	

}
