package com.example.demo.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Clase que retorna un mensaje cuando la autenticacion no es valida
 */
@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint{

	//Clase 
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		
		//error 401 unautentication no autenticado 
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
 
        final Map<String, Object> body = new HashMap<>();
        body.put("status", HttpServletResponse.SC_FORBIDDEN);
        body.put("error", "Unauthorized");
        body.put("message", authException.getMessage());
        body.put("path", request.getServletPath());
        body.put("adicional", "Revisa bien tu usuario y tu password");
 
        final ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), body);
		
		
	}

}
