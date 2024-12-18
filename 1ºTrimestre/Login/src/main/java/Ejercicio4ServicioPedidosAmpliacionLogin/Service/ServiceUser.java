package Ejercicio4ServicioPedidosAmpliacionLogin.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Ejercicio4ServicioPedidosAmpliacionLogin.Dao.DaoUser;
import Ejercicio4ServicioPedidosAmpliacionLogin.User.User;

public class ServiceUser extends Service implements ServiceInterface {

	DaoUser daoU;
	private static final Logger log = LoggerFactory.getLogger(ServiceUser.class);

	public ServiceUser() {
		this.daoU = new DaoUser();
	}

	@Override
	public void changePassword(Long id, String oldPass, String newPass) throws ConsultException {
		try (Connection conn = abrirConexion()) {
			User user = daoU.getById(conn, id);
			if (user != null) {
				if (!oldPass.equals(newPass)) {
					if (user.getPassword().equals(DigestUtils.sha256Hex(oldPass))) {
						user.setPassword(DigestUtils.sha256Hex(newPass));
						daoU.updateUser(conn, user);
						log.debug("Cambiando la password");
					} else {
						log.info("Las password no coincide");
						throw new ConsultException("La password antigua no coincide");
					}
				} else {
					log.info("La nueva password es igual a la antigua");
					throw new ConsultException("La password no puede ser igual");
				}
			} else {
				log.warn("El usuario con el id " + id + " no existe");
				throw new ConsultException("El usuario no existe");
			}

		} catch (SQLException e) {
			log.error("Error de SQL al cambiar la password del usuario con ID " + id, e);
			throw new ConsultException();
		}

	}

	@Override
	public User register(User user) throws InsertException, SQLException {
		try (Connection conn = abrirConexion()) {
			User existsUser = daoU.getByEmail(conn, user.getEmail());
			if (existsUser != null) {
				throw new InsertException("El usuario ya existe con el email indicado");
			}
			existsUser = daoU.getByUsername(conn, user.getUsername());
			if (existsUser != null) {
				throw new InsertException("El usuario ya existe con el username indicado");
			}
			try {
				user.setRegDate(LocalDate.now());
				user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
				Long id = daoU.insertUser(conn, user);
				user.setId(id);
				log.debug("Usuario resgistrado");
				return user;

			} catch (SQLException e) {
				log.error("Error al registrar al usuario: " + user.getEmail(), e);
				throw new InsertException("No ha sido posible insertar al usuario");
			}
		}
	}

	@Override
	public User login(String username, String password) throws ConsultException {

		try (Connection conn = abrirConexion()) {

			User user = daoU.getByUsername(conn, username);
			if (user != null) {
				if (user.getPassword().equals(DigestUtils.sha256Hex(password))) {
					user.setLastLoginDate(LocalDate.now());
					daoU.updateUser(conn, user);
					log.info("Login correcto para el usuario: " + username);
					return user;
				}
				log.warn("password incorrecta para el usuario con el nombre: " + username);
				throw new ConsultException("password incorrecta.");
			}

			user = daoU.getByEmail(conn, username);
			if (user != null) {
				if (user.getPassword().equals(DigestUtils.sha256Hex(password))) {
					user.setLastLoginDate(LocalDate.now());
					daoU.updateUser(conn, user);
					log.info("Login correcto para el usuario con email: " + username);
					return user;
				}
				log.warn("password incorrecta para el usuario con el email: " + username);
				throw new ConsultException("password incorrecta.");
			} else {
				log.warn("Usuario no encontrado con el nombre o email: " + username);
				throw new ConsultException("No se ha encontrado ningún usuario.");
			}

		} catch (SQLException e1) {
			log.error("Error en la base de datos durante el login para el usuario: " + username, e1);
			throw new ConsultException();
		}
	}

	@Override
	public User consultar(Long id) throws ConsultException {
		User user = null;
		try (Connection conn = abrirConexion()) {
			log.debug("consulta realizada con exito");
			return user = daoU.getById(conn, id);

		} catch (SQLException e1) {
			log.error("Error en la consulta de usuario con ID " + id, e1);
			throw new ConsultException("No se ha encontrado al usuario");
		}

	}

}
