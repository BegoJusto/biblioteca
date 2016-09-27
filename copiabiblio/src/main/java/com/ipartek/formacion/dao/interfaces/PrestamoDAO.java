package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.dao.persistencia.Prestamo;

public interface PrestamoDAO {

	public Prestamo create(Prestamo prestamo);
	
	public Prestamo getById(int id);
	
	public List<Prestamo> getAll();
	
	public Prestamo update(Prestamo prestamo);
	
	public void delete(int id);

	public void setDataSource(DataSource dataSource);

	public List<Prestamo> getByIdUsuario(int id);
	
	public List<Prestamo> getByIdEjemplar(int id);
}
