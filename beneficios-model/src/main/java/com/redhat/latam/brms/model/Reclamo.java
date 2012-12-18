package com.redhat.latam.brms.model;

import java.util.Date;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;

@Entity("reclamos")
public class Reclamo {

	@Id
	private ObjectId id;

	@Reference
	private Cliente cliente;
	private Date fecha;
	private String tipoDeReclamo;
	private String comentario;

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

	public String getTipoDeReclamo() {

		return tipoDeReclamo;
	}

	public void setTipoDeReclamo(String tipoDeReclamo) {

		this.tipoDeReclamo = tipoDeReclamo;
	}

	public String getComentario() {

		return comentario;
	}

	public void setComentario(String comentario) {

		this.comentario = comentario;
	}
}
