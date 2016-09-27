package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.UsuarioDAO;
import com.ipartek.formacion.dao.mapper.UsuarioMapper;
import com.ipartek.formacion.dao.persistencia.Usuario;

@Repository("usuarioDAOImp")
public class UsuarioDAOImp implements UsuarioDAO {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImp.class);
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall jdbcCall;

	@Override
	public List<Usuario> getAll() {

		List<Usuario> usuarios = new ArrayList<Usuario>();
		final String SQL = "SELECT codUsuario, nombre, apellidos,fNacimiento,mail,username, password FROM usuario;";

		try {
			
			usuarios = jdbcTemplate.query(SQL, new UsuarioMapper());
		} catch (EmptyResultDataAccessException e) {
			
			usuarios = new ArrayList<Usuario>();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	@Override
	public Usuario create(Usuario usuario) {
		final String SQL = "INSERT INTO usuario (nombre,apellidos,fNacimiento, mail, username, password) VALUES (?,?,?,?,?,?);";
		
		jdbcTemplate.update(SQL,
				new Object[] { usuario.getNombre(), usuario.getApellidos(), usuario.getfNacimiento(), usuario.getMail(),
				usuario.getUsername(), usuario.getPassword()});

		return usuario;
	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM usuario WHERE codUsuario = ?;";
		jdbcTemplate.update(SQL, new Object[] { id });

	}

	@Override
	public Usuario update(Usuario usuario) {

		final String SQL = "UPDATE usuario SET nombre = ?, apellidos = ?,fNacimiento = ?, mail = ?, username = ?, password = ? WHERE codUsuario = ?";
		this.jdbcTemplate.update(SQL, usuario.getNombre(),
				usuario.getApellidos(), usuario.getfNacimiento(), usuario.getMail(),
				usuario.getUsername(), usuario.getPassword(), usuario.getCodigo());
		return usuario;
	}



	@Override
	public Usuario getById(int id) {
		Usuario usuario = null;
		final String SQL = "SELECT codUsuario, nombre, apellidos, fNacimiento, mail, username, password FROM usuario WHERE codUsuario = ?;";
		try {
			usuario = jdbcTemplate.queryForObject(SQL, new Object[] { id },
					new UsuarioMapper());
		} catch (EmptyResultDataAccessException e) {
			usuario = new Usuario();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return usuario;
	}

	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {

		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcCall = new SimpleJdbcCall(dataSource);

	}

}
