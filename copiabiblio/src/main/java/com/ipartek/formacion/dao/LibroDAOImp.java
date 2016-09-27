package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.LibroDAO;
import com.ipartek.formacion.dao.mapper.LibroMapper;
import com.ipartek.formacion.dao.persistencia.Libro;
import com.ipartek.formacion.dao.persistencia.Libro;

@Repository("libroDAOImp")
public class LibroDAOImp implements LibroDAO {
	private static final Logger logger = LoggerFactory.getLogger(LibroDAOImp.class);
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall jdbcCall;

	@Override
	public List<Libro> getAll() {

		List<Libro> libros = new ArrayList<Libro>();
		final String SQL = "SELECT codLibro, titulo, autor, isbn, numEjemplares FROM libro;";

		try {
			
			libros = jdbcTemplate.query(SQL, new LibroMapper());
		} catch (EmptyResultDataAccessException e) {
			logger.error(e.getMessage());
			libros = new ArrayList<Libro>();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return libros;
	}

	@Override
	public Libro create(Libro libro) {
		final String SQL = "INSERT INTO libro (titulo, autor, isbn, numEjemplares) VALUES (?,?,?,?);";
		jdbcTemplate.update(SQL,
				new Object[] { libro.getTitulo(), libro.getAutor(), libro.getIsbn(), libro.getNumEjemplares() });

		return libro;
	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM libro WHERE codLibro = ?;";
		jdbcTemplate.update(SQL, new Object[] { id });

	}

	@Override
	public Libro update(Libro libro) {

		final String SQL = "UPDATE libro SET titulo = ?, autor = ?, isbn = ?, numEjemplares = ? WHERE codLibro = ?";
		this.jdbcTemplate.update(SQL, libro.getTitulo(), libro.getAutor(), libro.getIsbn(), libro.getCodigo(), libro.getNumEjemplares());
		logger.info("titulo", libro.getTitulo());
		logger.info("ator", libro.getAutor());
		return libro;
	}



	@Override
	public Libro getById(int id) {
		Libro libro = null;
		final String SQL = "SELECT codLibro, titulo, autor, isbn, numEjemplares FROM libro WHERE codLibro = ?;";
		try {
			libro = jdbcTemplate.queryForObject(SQL, new Object[] { id },
					new LibroMapper());
		} catch (EmptyResultDataAccessException e) {
			libro = new Libro();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return libro;
	}

	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {

		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcCall = new SimpleJdbcCall(dataSource);

	}

}
