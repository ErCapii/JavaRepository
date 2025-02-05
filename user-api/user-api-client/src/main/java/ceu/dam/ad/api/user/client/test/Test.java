package ceu.dam.ad.api.user.client.test;

import ceu.dam.ad.api.user.client.ApiClient;
import ceu.dam.ad.api.user.client.ApiException;
import ceu.dam.ad.api.user.client.api.UserApiApi;
import ceu.dam.ad.api.user.client.model.CreateUserRequest;
import ceu.dam.ad.api.user.client.model.User;

public class Test {

	public static void main(String[] args) {
		ApiClient client = new ApiClient();
		client.setBasePath("http://localhost:8080");
		client.setApiKey("quistian");
		
		UserApiApi service = new UserApiApi(client);
		try {
		CreateUserRequest userR = new CreateUserRequest();
		userR.setUsername("Blablalbaladdadwad");
		userR.setEmail("fdfsdfsdfsdfsdawdadfsdf@ffafe.com");
		userR.setPassword("dadadadadawawdad");
		User user = service.crearUsario(userR);
		Long id = user.getId();
		user = service.consultarUser(id);
		System.out.println(user);
		}catch(ApiException e) {
			System.out.println(e.getCode());
			System.out.println(e.getLocalizedMessage());
		}
	}
}
