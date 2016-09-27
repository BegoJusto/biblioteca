package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.dao.persistencia.Ejemplar;

public interface EjemplarDAO {

	public Ejemplar create(Ejemplar ejemplar);
	
	public Ejemplar getById(int id);
	
	public List<Ejemplar> getAll();
	
	public Ejemplar update(Ejemplar ejemplar);
	
	public void delete(int id);

	void setDataSource(DataSource dataSource);
}
