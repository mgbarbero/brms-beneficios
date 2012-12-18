package com.redhat.latam.brms.model;

import java.util.Date;

public class Reclamo {

	private Cliente cliente;
	private Date fecha;

	public Cliente getCliente() {

		return cliente;
	}

	public void setCliente(Cliente cliente) {

		this.cliente = cliente;
	}

	public Date getFecha() {

		return fecha;
	}

	public void setFecha(Date fecha) {

		this.fecha = fecha;
	}
}
