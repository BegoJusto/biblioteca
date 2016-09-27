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

import com.ipartek.formacion.dao.interfaces.PrestamoDAO;
import com.ipartek.formacion.dao.mapper.PrestamoMapper;
import com.ipartek.formacion.dao.mapper.UsuarioMapper;
import com.ipartek.formacion.dao.persistencia.Prestamo;
import com.ipartek.formacion.dao.persistencia.Usuario;

@Repository("prestamoDAOImp")
public class PrestamoDAOImp implements PrestamoDAO {
	private static final Logger logger = LoggerFactory.getLogger(PrestamoDAOImp.class);
	
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall jdbcCall;

	@Override
	public Prestamo create(Prestamo prestamo) {
		final String SQL = "INSERT INTO prestamo (fechaRecogida, fechaDevoPrevista ,fechaDevolucionReal, codUsuario, codEjemplar) VALUES (?,?,?,?,?);";
		
		jdbcTemplate.update(SQL,
				new Object[] { prestamo.getfRecogida(), prestamo.getfDevolucionPrevista(), prestamo.getfDevolucionReal(), prestamo.getEjemplar().getCodigo(), prestamo.getUsuario().getCodigo()});

		return prestamo;
	}

	@Override
	public List<Prestamo> getAll() {

		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		final String SQL = "SELECT codPrestamo, fechaRecogida, fechaDevoPrevista ,fechaDevolucionReal, codUsuario, codEjemplar FROM prestamo;";

		try {
			
			prestamos = jdbcTemplate.query(SQL, new PrestamoMapper());
		} catch (EmptyResultDataAccessException e) {
			
			prestamos = new ArrayList<Prestamo>();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prestamos;
	}

	@Override
	public Prestamo update(Prestamo prestamo) {
		final String SQL = "UPDATE usuario SET fechaRecogida = ?, fechaDevoPrevista = ?,fechaDevolucionReal = ?, codUsuario = ?, codEjemplar = ? WHERE codPrestamo = ?";
		this.jdbcTemplate.update(SQL, prestamo.getfRecogida(),
				prestamo.getfDevolucionPrevista(), prestamo.getfDevolucionReal(), prestamo.getUsuario().getCodigo(), prestamo.getEjemplar().getCodigo());
		return prestamo;
	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM prestamo WHERE codPrestamo = ?;";
		jdbcTemplate.update(SQL, new Object[] { id });


	}

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcCall = new SimpleJdbcCall(dataSource);

	}

	@Override
	public Prestamo getById(int id) {
		Prestamo prestamo = null;
		final String SQL = "SELECT fechaRecogida, fechaDevoPrevista ,fechaDevolucionReal, codUsuario, codEjemplar FROM prestamo WHERE codPrestamo = ?;";
		try {
			prestamo = jdbcTemplate.queryForObject(SQL, new Object[] { id },
					new PrestamoMapper());
		} catch (EmptyResultDataAccessException e) {
			prestamo = new Prestamo();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return prestamo;
	}

	@Override
	public List<Prestamo> getByIdUsuario(int id) {
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		final String SQL = "SELECT fechaRecogida, fechaDevoPrevista ,fechaDevolucionReal, codUsuario, codEjemplar FROM prestamo WHERE codUsuario = ?;";
		try {			
			prestamos = jdbcTemplate.query(SQL, new PrestamoMapper());
		} catch (EmptyResultDataAccessException e) {
			
			prestamos = new ArrayList<Prestamo>();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prestamos;		
	}
	
	@Override
	public List<Prestamo> getByIdEjemplar(int id) {
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		final String SQL = "SELECT fechaRecogida, fechaDevoPrevista ,fechaDevolucionReal, codUsuario, codEjemplar FROM prestamo WHERE codEjemplar = ?;";
		try {			
			prestamos = jdbcTemplate.query(SQL, new PrestamoMapper());
		} catch (EmptyResultDataAccessException e) {
			
			prestamos = new ArrayList<Prestamo>();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prestamos;		
	}

}
