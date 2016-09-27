/**
 * 
 */
package com.ipartek.formacion.dao.persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Curso
 *
 */
public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;
	@Min(value=0)
	private int codigo;
	@NotNull
	private String titulo;
	@NotNull
	private String autor;
	@NotNull
	private String isbn;
	@Min(value=0)
	private int numEjemplares;

	/**
	 * 
	 */
	public Libro() {
		super();
		setCodigo(0);
		setAutor("");
		setTitulo("");
		setIsbn("");
		setNumEjemplares(0);
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getNumEjemplares() {
		return numEjemplares;
	}

	public void setNumEjemplares(int numEjemplares) {
		this.numEjemplares = numEjemplares;
	}
	
	

}
