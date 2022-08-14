package com.api.rest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.dao.PersonaDAO;
import com.api.rest.models.Persona;

@RestController
@RequestMapping("personas")
public class PersonaRest {

	@Autowired
	private PersonaDAO personaDAO;
	
//	Metodos HTTP - Peticiones al servidor
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Persona persona) {
		personaDAO.save(persona);
	}
	
	
}
