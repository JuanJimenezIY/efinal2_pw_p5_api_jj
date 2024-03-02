package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IEstudianteService;
import com.example.demo.service.to.EstudianteTO;

@RestController
@CrossOrigin
@RequestMapping("/estudiantes")
public class EstudianteControlerRestFul {

	@Autowired
	private IEstudianteService estudianteService;
	
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<EstudianteTO> guardar(@RequestBody EstudianteTO estudianteTO) {
		EstudianteTO estudiante= this.estudianteService.guardarTO(estudianteTO);
		return new ResponseEntity<>(estudiante,null,200);
	}
}
