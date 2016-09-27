package com.ipartek.formacion.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.ipartek.formacion.dao.persistencia.Prestamo;
import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.dao.persistencia.Usuario;

public class PrestamoMapper implements RowMapper<Prestamo>{

	@Override
	public Prestamo mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Prestamo prestamo = new Prestamo();
		prestamo.setCodigo(rs.getInt("codPrestamo"));
		prestamo.setfRecogida(rs.getDate("fechaRecogida"));
		prestamo.setfDevolucionPrevista(rs.getDate("fechaDevoPrevista"));
		prestamo.setfDevolucionReal(rs.getDate("fechaDevolucionReal"));
		
		Usuario usuario = new Usuario();
		usuario.setCodigo(rs.getInt("codUsuario")) ;
		prestamo.setUsuario(usuario);
		
		Ejemplar ejemplar = new Ejemplar();
		ejemplar.setCodigo(rs.getInt("codEjemplar")) ;
		prestamo.setEjemplar(ejemplar);
		
		return prestamo;
	}

}
