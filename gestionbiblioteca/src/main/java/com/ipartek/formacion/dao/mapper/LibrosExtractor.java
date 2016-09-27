package com.ipartek.formacion.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.dao.persistencia.Libro;
import com.ipartek.formacion.dao.persistencia.Usuario;


public class LibrosExtractor implements ResultSetExtractor<List<Libro>> {

	@Override
	public List<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Libro> map = new HashMap<Integer, Libro>();
		// List<Libro> libros = new ArrayList<Libro>();
		Libro libro = null;

		while (rs.next()) {
			Integer id = rs.getInt("libroCodigo");
			libro = map.get(id);
			if (libro == null) {
				libro = new Libro();
				libro.setIsbn(rs.getString("libroISBN"));
				libro.setCodigo(rs.getInt("libroCodigo"));
				libro.setTitulo(rs.getString("libroTitulo"));

				map.put(id, libro);
			}
			Usuario usuario = new Usuario();
			usuario.setCodigo(rs.getInt("usuarioCodigo"));
			Ejemplar ejemplar = new Ejemplar(usuario);
			ejemplar.setNumPaginas(rs.getInt("ejemplarNpaginas"));
			libro.addEjemplar(ejemplar);
		}
		return new ArrayList<Libro>(map.values());
	}

}