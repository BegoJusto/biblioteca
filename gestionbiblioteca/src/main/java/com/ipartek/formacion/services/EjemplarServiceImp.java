package com.ipartek.formacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.dao.EjemplarDAOImp;
import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.services.interfaces.EjemplarService;

public class EjemplarServiceImp implements EjemplarService {

	@Autowired
	private EjemplarDAOImp ejemplarDAO;
	
	@Override
	public Ejemplar create(Ejemplar ejemplar) {
		
		return ejemplarDAO.create(ejemplar);
	}

	@Override
	public List<Ejemplar> getAll() {
		
		return ejemplarDAO.getAll();
	}

	@Override
	public Ejemplar getById(int id) {
		
		return ejemplarDAO.getById(id);
	}

	@Override
	public Ejemplar update(Ejemplar ejemplar) {
		
		return ejemplarDAO.update(ejemplar);
	}

	@Override
	public void delete(int id) {
		ejemplarDAO.delete(id);

	}

	@Override
	public void setEjemplarDAO(EjemplarDAOImp ejemplarDAO) {
		this.ejemplarDAO = ejemplarDAO;
		
	}

}
