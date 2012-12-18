package com.redhat.latam.brms.model;

import java.util.Date;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;

@Entity("respuestas")
public class Respuesta {

	@Id
	private ObjectId id;

	@Reference
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
