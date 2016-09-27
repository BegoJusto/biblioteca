package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.dao.persistencia.Libro;

public interface LibroDAO {
	
	public Libro create(Libro libro);
	
	public Libro getById(int id);
	
	public List<Libro> getAll();
	
	public Libro update(Libro libro);
	
	public void delete(int id);

	void setDataSource(DataSource dataSource);

}
