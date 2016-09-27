package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.dao.persistencia.Libro;

public interface LibroDAO extends DAOSetter {

	public List<Libro> getAll();

	public List<Libro> find(Libro libro);
}
