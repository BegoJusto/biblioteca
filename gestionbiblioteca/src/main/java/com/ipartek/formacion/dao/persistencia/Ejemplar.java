/**
 * 
 */
package com.ipartek.formacion.dao.persistencia;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Curso
 *
 */
public class Ejemplar extends Libro{
	private static final long serialVersionUID = 1L;
	
	@Min(value=0)
	private int codigo;
	@NotNull
	private String editorial;
	@Min(value=5)
	private int numPaginas;
	private Usuario usuario;
	

	/**
	 * 
	 */
	public Ejemplar(Usuario usuario) {
		super();
		setCodigo(0);
		setEditorial("");
		setNumPaginas(0);
		setUsuario(usuario);
		
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getEditorial() {
		return editorial;
	}


	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}


	public int getNumPaginas() {
		return numPaginas;
	}


	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
