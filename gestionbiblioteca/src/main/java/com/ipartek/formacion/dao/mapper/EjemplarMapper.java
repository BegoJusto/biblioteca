package com.ipartek.formacion.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.dao.persistencia.Usuario;

public class EjemplarMapper implements RowMapper<Ejemplar>{

	@Override
	public Ejemplar mapRow(ResultSet rs, int arg1) throws SQLException {
		/*
		 * FALTA ARREGLAR ESTO. NO PUEDE FUNCIONAR ASÍ
		 */
		Usuario usuario = new Usuario();
		Ejemplar ejemplar = new Ejemplar(usuario);
		ejemplar.setCodigo(rs.getInt("codEjemplar"));
		ejemplar.setEditorial(rs.getString("editorial"));
		ejemplar.setNumPaginas(rs.getInt("numPaginas"));
		
		return ejemplar;
	}

}
