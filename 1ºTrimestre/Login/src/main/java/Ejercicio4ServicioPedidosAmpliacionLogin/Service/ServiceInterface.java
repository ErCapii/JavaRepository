package Ejercicio4ServicioPedidosAmpliacionLogin.Service;

import java.sql.SQLException;

import Ejercicio4ServicioPedidosAmpliacionLogin.Service.ConsultException;
import Ejercicio4ServicioPedidosAmpliacionLogin.Service.InsertException;
import Ejercicio4ServicioPedidosAmpliacionLogin.User.User;

public interface ServiceInterface {

	public void changePassword(Long id, String oldPass, String newPass) throws ConsultException;

	public User register(User user) throws InsertException, SQLException;

	public User login(String username, String password) throws ConsultException;

	public User consultar(Long id) throws ConsultException;

}
