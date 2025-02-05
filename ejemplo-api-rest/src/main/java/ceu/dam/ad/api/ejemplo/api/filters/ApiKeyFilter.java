package ceu.dam.ad.api.ejemplo.api.filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class ApiKeyFilter extends OncePerRequestFilter{

	@Value("${api.key}")
	private String apiKey;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//Obtiene el api key enviado desde la cabecera de la peticion
		String apiKeyRequest = request.getHeader("API-KEY");
		
		//El apiKey primero por si el request es null no de un nullpointer
		if(apiKey.equals(apiKeyRequest)) {
			filterChain.doFilter(request, response);//Si ok, sigue con los siguientes filtros
		}
		else {
			//Devuelve un mensaje de error
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			response.getWriter().write("Fuera quistian");
		}
		
	}

	
}
