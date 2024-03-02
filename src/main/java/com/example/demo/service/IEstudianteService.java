package com.example.demo.service;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

public interface IEstudianteService {
	
	public void guardar(Estudiante estudiante);
	
	public EstudianteTO guardarTO(EstudianteTO estudianteTO);
}
