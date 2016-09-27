package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistencia.Usuario;

public interface UsuarioDAO extends DAOSetter{
	
	public Usuario create(Usuario usuario);
	
	public Usuario getById(int id);
	
	public List<Usuario> getAll();
	
	public Usuario update(Usuario usuario);
	
	public void delete(int id);
	
	
}
