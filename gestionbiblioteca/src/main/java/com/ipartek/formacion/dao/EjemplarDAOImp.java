package com.ipartek.formacion.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.EjemplarDAO;
import com.ipartek.formacion.dao.mapper.EjemplarMapper;
import com.ipartek.formacion.dao.mapper.LibrosExtractor;
import com.ipartek.formacion.dao.persistencia.Ejemplar;
import com.ipartek.formacion.dao.persistencia.Libro;



@Repository("ejemplarDAOImp")
public class EjemplarDAOImp implements EjemplarDAO {

	@SuppressWarnings("unused")
	@Autowired
	private DataSource dataSource;
	private SimpleJdbcCall jdbcCall;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Libro> getAll() {
		List<Libro> libros = null;
		final String SQL = "call OBTENER_CATOLOGO()";

		libros = jdbcTemplate.query(SQL, new LibrosExtractor());

		return libros;
	}

	@Override
	public List<Libro> find(Libro libro) {
		List<Libro> libros = null;
		final String SQL = "call CONSULTAR_CATOLOGO(?,?)";
		libros = jdbcTemplate.query(SQL, new Object[] { libro.getIsbn(), libro.getTitulo() }, new LibrosExtractor());

		return libros;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ejemplar> getEjemplares(Libro libro) {
		List<Ejemplar> ejemplares = null;
		final String SQL = "OBTENER_EJEMPLARES";
		jdbcCall.withProcedureName(SQL).returningResultSet("listado", new EjemplarMapper());
		SqlParameterSource in = new MapSqlParameterSource().addValue("codigoLibro", libro.getCodigo());
		ejemplares = (List<Ejemplar>) jdbcCall.execute(in).get("listado");

		return ejemplares;
	}

	@Override
	public Ejemplar getEjemplar(int codEjemplar) {
		final String SQL = "OBTENER_EJEMPLAR";
		Ejemplar ejemplar = null;
		jdbcCall.withProcedureName(SQL).returningResultSet("ejemplar", new EjemplarMapper());
		SqlParameterSource in = new MapSqlParameterSource().addValue("codigoEjemplar", codEjemplar);
		ejemplar = (Ejemplar) jdbcCall.execute(in).get("ejemplar");
		return ejemplar;
	}

	@Override
	public void delete(int codLibro) {
		final String SQL = "BORRAR_EJEMPLAR";
		jdbcCall.withProcedureName(SQL);
		SqlParameterSource in = new MapSqlParameterSource().addValue("codigoLibro", codLibro);
		jdbcCall.execute(in);
	}

	@Override
	public Ejemplar update(Ejemplar ejemplar) {
		final String SQL = "ACTUALIZAR_EJEMPLAR";
		jdbcCall.withProcedureName(SQL);
		SqlParameterSource in = new MapSqlParameterSource().addValue("codigoEjemplar", ejemplar.getCodigo())
				.addValue("pIsbn", ejemplar.getIsbn()).addValue("pNpaginas", ejemplar.getCodigo())
				.addValue("pTitulo", ejemplar.getTitulo()).addValue("pCodigoLibro", ejemplar.getCodigo());
		jdbcCall.execute(in);

		return ejemplar;
	}
	
	@Override
	public Ejemplar create(Ejemplar ejemplar) {
		final String SQL = "INSERT INTO ejemplar (editorial, numPaginas) VALUES (?,?);";
		jdbcTemplate.update(SQL,
				new Object[] { ejemplar.getEditorial(), ejemplar.getNumPaginas() });

		return ejemplar;
	}

}
