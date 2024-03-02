package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService{
	@Autowired
	private IEstudianteRepository iEstudianteRepository;
	
	@Override
	public EstudianteTO guardarTO(EstudianteTO estudiante) {
		// TODO Auto-generated method stub
		this.iEstudianteRepository.insertar( this.convertirTO(estudiante));
		
		return this.convertir(this.iEstudianteRepository.buscarPorCedula(estudiante.getCedula()));
		
	}
	
	private EstudianteTO convertir(Estudiante est) {

		EstudianteTO estuTO = new EstudianteTO();
		estuTO.setApellido(est.getApellido());
		estuTO.setCedula(est.getCedula());
	
		estuTO.setNombre(est.getNombre());
		estuTO.setId(est.getId());
	

		return estuTO;
	}
	
	private Estudiante convertirTO(EstudianteTO estTO) {

		Estudiante estu = new Estudiante();
		estu.setApellido(estTO.getApellido());
		estu.setCedula(estTO.getCedula());
	
		estu.setNombre(estTO.getNombre());
		estu.setId(estTO.getId());
	

		return estu;
	}

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.iEstudianteRepository.insertar(estudiante);
	}
	

}
