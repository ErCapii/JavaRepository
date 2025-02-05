package ceu.dam.ad.users.api.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ApiKeyFilter extends OncePerRequestFilter {
	@Value("${api.key}")
	private String apiKey;

	@Override // Permite el acceso a Swagger y docs sin clave API
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		String path = request.getRequestURI();
		return (path.startsWith("/swagger") || path.startsWith("/docs"));
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String apiKeyRequest = request.getHeader("API-KEY");
		// Validar la clave API
		if (apiKey != null && apiKey.equals(apiKeyRequest)) {
			filterChain.doFilter(request, response);
		} else {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			response.getWriter().write("Unauthorized access - invalid API key");
		}
	}

}
