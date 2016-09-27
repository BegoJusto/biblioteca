package com.ipartek.formacion.dao.persistencia;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.validation.constraints.Min;

public class Prestamo implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final int dias = 15;
	@Min(value=0)
	private int codigo;
	private Date fRecogida;
	private Date fDevolucionPrevista;
	private Date fDevolucionReal;
	private Usuario usuario;
	private Ejemplar ejemplar;
	
	public Prestamo() {
		super();
		setCodigo(0);
		setfRecogida(fRecogida);
		setfDevolucionPrevista(fDevolucionPrevista);
		setfDevolucionReal(fDevolucionReal);
		
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getfRecogida() {
		return fRecogida;
	}
	
	public void setfRecogida(Date fRecogida) {
		this.fRecogida = fRecogida;
	}
	
	public Date getfDevolucionPrevista() {
		return fDevolucionPrevista;
	}
	
	public  void setfDevolucionPrevista(Date fDevolucionPrevista) {
		Calendar cal = new GregorianCalendar();
		Date hoy = new Date();
        cal.setTimeInMillis(hoy.getTime());
        cal.add(Calendar.DATE, dias);
        this.fDevolucionPrevista =  new java.sql.Date(cal.getTimeInMillis());
    }
	
	public Date getfDevolucionReal() {
		return fDevolucionReal;
	}
	
	public void setfDevolucionReal(Date fDevolucionReal) {
		Date hoy = new Date();
		this.fDevolucionReal = hoy;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Ejemplar getEjemplar() {
		return ejemplar;
	}
	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}



	
}
