package com.ipartek.formacion.services.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.EjemplarDAOImp;
import com.ipartek.formacion.dao.LibroDAOImp;
import com.ipartek.formacion.dao.persistencia.Ejemplar;

public interface EjemplarService {
	
	public Ejemplar create(Ejemplar ejemplar);
	
	public List<Ejemplar> getAll();
	
	public Ejemplar getById(int id);
	
	public Ejemplar update(Ejemplar ejemplar);
	
	public void delete(int id);
	
	public void setEjemplarDAO(EjemplarDAOImp ejemplarDAO);

}
