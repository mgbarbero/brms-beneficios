package com.redhat.latam.brms.model;

import java.util.Date;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class Respuesta {

	@Id
	private ObjectId id;

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
