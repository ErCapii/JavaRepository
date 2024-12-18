package Ejercicio4ServicioPedidosAmpliacionLogin.TEst;

import java.sql.SQLException;

import Ejercicio4ServicioPedidosAmpliacionLogin.Service.ConsultException;
import Ejercicio4ServicioPedidosAmpliacionLogin.Service.InsertException;
import Ejercicio4ServicioPedidosAmpliacionLogin.Service.ServiceUser;
import Ejercicio4ServicioPedidosAmpliacionLogin.User.User;

public class Test {

	public static void main(String[] args) throws InsertException, SQLException, ConsultException {

		ServiceUser srU = new ServiceUser();
		User user = new User();
		user.setUsername("Alejandro");
		user.setEmail("hola@gmail.com");
		user.setPassword("1234");
		user = srU.register(user);
		user = srU.login(user.getUsername(), "1234");
		System.out.println(user);
		System.out.println(user.getPassword());
		srU.changePassword(user.getId(), "1234", "4321");
		System.out.println(srU.consultar(user.getId()));
	}

}
