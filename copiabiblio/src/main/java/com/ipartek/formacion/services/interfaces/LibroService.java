package com.ipartek.formacion.services.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.LibroDAOImp;
import com.ipartek.formacion.dao.persistencia.Libro;

public interface LibroService {
	
	public Libro create(Libro libro);
		
	public List<Libro> getAll();
	
	public Libro getById(int id);

	public Libro update(Libro libro);
	
	public void delete(int id);
	
	public void setLibroDAO(LibroDAOImp libroDAO);

}
