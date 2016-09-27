package com.ipartek.formacion.dao.persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Min(value=0)
	private int codigo;
	@NotNull
	private String nombre;
	@NotNull
	private String apellidos;
	@NotNull
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date fNacimiento;
	@Email
	private String mail;	
	@NotNull
	private String username;
	@NotEmpty
	private String password;
	private List<Prestamo> prestamos;

	public Usuario() {
		super();
		setCodigo(0);
		setNombre("");
		setApellidos("");
		setfNacimiento(fNacimiento);
		setMail("");
		setUsername("");
		setPassword("12345");
		prestamos = new ArrayList<Prestamo>();
		
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
