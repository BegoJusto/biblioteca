package com.ipartek.formacion.dao.interfaces;

import java.util.List;
import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.dao.persistencia.Libro;

public interface EjemplarDAO extends LibroDAO {

	public List<Ejemplar> getAll(Libro libro);

	public Ejemplar getById(int id);

	public void delete(int id);

	public Ejemplar update(Ejemplar ejemplar);
	
	public Ejemplar create(Ejemplar ejemplar);

}