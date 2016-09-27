package com.ipartek.formacion.services;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.dao.PrestamoDAOImp;
import com.ipartek.formacion.dao.UsuarioDAOImp;
import com.ipartek.formacion.dao.interfaces.PrestamoDAO;
import com.ipartek.formacion.dao.persistencia.Prestamo;
import com.ipartek.formacion.services.interfaces.PrestamoService;

public class PrestamoServiceImp implements PrestamoService{

	@Autowired
	private PrestamoDAOImp prestamoDAO;
	@Override
	public Prestamo create(Prestamo prestamo) {
		
		return prestamoDAO.create(prestamo);
	}

	@Override
	public Prestamo getById(int id) {
		
		return prestamoDAO.getById(id);
	}

	@Override
	public List<Prestamo> getAll() {
		
		return prestamoDAO.getAll();
	}

	@Override
	public Prestamo update(Prestamo prestamo) {
		
		return prestamoDAO.update(prestamo);
	}

	@Override
	public void delete(int id) {
		prestamoDAO.delete(id);
		
	}
	@Override
	public void setPrestamoDAO(PrestamoDAOImp prestamoDAO) {
		this.prestamoDAO = prestamoDAO;
		
	}

	public List<Prestamo> getByIdUsuario(int id) {
		
		return prestamoDAO.getByIdUsuario(id);
	}
	

}
