package com.ipartek.formacion.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistencia.Libro;


public class LibroMapper implements RowMapper<Libro>{

	@Override
	public Libro mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Libro libro = new Libro();
		libro.setCodigo(rs.getInt("codLibro"));
		libro.setTitulo(rs.getString("titulo"));
		libro.setAutor(rs.getString("autor"));
		libro.setIsbn(rs.getString("isbn"));
		libro.setNumEjemplares(rs.getInt("numEjemplares"));
		
		return libro;
	}

}
