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

import com.ipartek.formacion.dao.interfaces.EjemplarDAO;
import com.ipartek.formacion.dao.mapper.EjemplarMapper;
import com.ipartek.formacion.dao.persistencia.Ejemplar;

@Repository("ejemplarDAOImp")
public class EjemplarDAOImp implements EjemplarDAO {
	private static final Logger logger = LoggerFactory.getLogger(EjemplarDAOImp.class);
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall jdbcCall;

	@Override
	public List<Ejemplar> getAll() {

		List<Ejemplar> ejemplares = new ArrayList<Ejemplar>();
		final String SQL = "SELECT codEjemplar, editorial, numPaginas FROM ejemplar;";

		try {
			
			ejemplares = jdbcTemplate.query(SQL, new EjemplarMapper());
		} catch (EmptyResultDataAccessException e) {
			ejemplares = new ArrayList<Ejemplar>();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ejemplares;
	}

	@Override
	public Ejemplar create(Ejemplar ejemplar) {
		final String SQL = "INSERT INTO ejemplar (editorial, numPaginas) VALUES (?,?);";
		jdbcTemplate.update(SQL,
				new Object[] { ejemplar.getEditorial(), ejemplar.getNumPaginas() });

		return ejemplar;
	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM ejemplar WHERE codEjemplar = ?;";
		jdbcTemplate.update(SQL, new Object[] { id });

	}

	@Override
	public Ejemplar update(Ejemplar ejemplar) {

		final String SQL = "UPDATE ejemplar SET editorial = ?, numPaginas = ? WHERE codEjemplar = ?";
		this.jdbcTemplate.update(SQL, ejemplar.getEditorial(), ejemplar.getNumPaginas(), ejemplar.getCodigo());
		return ejemplar;
	}



	@Override
	public Ejemplar getById(int id) {
		Ejemplar ejemplar = null;
		final String SQL = "SELECT codEjemplar, editorial, numPaginas FROM ejemplar WHERE codEjemplar = ?;";
		try {
			ejemplar = jdbcTemplate.queryForObject(SQL, new Object[] { id },
					new EjemplarMapper());
		} catch (EmptyResultDataAccessException e) {
			ejemplar = new Ejemplar();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return ejemplar;
	}

	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {

		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcCall = new SimpleJdbcCall(dataSource);

	}

}
