package com.ipartek.formacion.services.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.UsuarioDAOImp;
import com.ipartek.formacion.dao.persistencia.Usuario;


public interface UsuarioService {
	
	public Usuario create(Usuario usuario);
	
	public Usuario getById(int id);
	
	public List<Usuario> getAll();
	
	public Usuario update(Usuario usuario); 
	
	public void delete(int id);
	
	public void setUsuarioDAO(UsuarioDAOImp usuarioDAO);

}
