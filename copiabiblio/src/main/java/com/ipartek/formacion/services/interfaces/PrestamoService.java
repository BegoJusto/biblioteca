package com.ipartek.formacion.services.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.PrestamoDAOImp;
import com.ipartek.formacion.dao.persistencia.Prestamo;
import com.ipartek.formacion.services.PrestamoServiceImp;


public interface PrestamoService {
public Prestamo create(Prestamo prestamo);
	
	public List<Prestamo> getAll();
	
	public Prestamo getById(int id);
	
	public Prestamo update(Prestamo prestamo);
	
	public void delete(int id);

	void setPrestamoDAO(PrestamoDAOImp prestamoDAO);

}
