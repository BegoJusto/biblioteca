package com.ipartek.formacion.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.controller.IndexController;
import com.ipartek.formacion.dao.UsuarioDAOImp;
import com.ipartek.formacion.dao.persistencia.Usuario;
import com.ipartek.formacion.services.interfaces.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImp.class);

	@Autowired
	private UsuarioDAOImp usuarioDAO = null;
		
	@Override
	public Usuario create(Usuario usuario) {
		logger.info("el Usuario DAO= !",usuarioDAO);
		return usuarioDAO.create(usuario);
	}

	@Override
	public Usuario getById(int id) {
		
		return usuarioDAO.getById(id);
	}

	@Override
	public List<Usuario> getAll() {
		
		return usuarioDAO.getAll();
	}

	@Override
	public Usuario update(Usuario usuario) {
		
		return usuarioDAO.update(usuario);
	}

	@Override
	public void delete(int id) {
		usuarioDAO.delete(id);

	}

	@Override
	public void setUsuarioDAO(UsuarioDAOImp usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
		
	}

}
