package com.redhat.latam.brms.model;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Transient;

@Entity("clientes")
public class Cliente {

	@Id
	private ObjectId id;

	@Transient
	private int beneficioSms;
	@Transient
	private int beneficioVoz;
	@Transient
	private int puntos;
	
	private String tipoAbono;
	private int edad;
	private String tipoContrato;

	public ObjectId getId() {

		return this.id;
	}

	public String getTipoAbono() {

		return tipoAbono;
	}

	public void setTipoAbono(String tipoAbono) {

		this.tipoAbono = tipoAbono;
	}

	public int getBeneficioSms() {

		return beneficioSms;
	}

	public void setBeneficioSms(int beneficioSms) {

		this.beneficioSms = beneficioSms;
	}

	public int getBeneficioVoz() {

		return beneficioVoz;
	}

	public void setBeneficioVoz(int beneficioVoz) {

		this.beneficioVoz = beneficioVoz;
	}

	public int getEdad() {

		return edad;
	}

	public void setEdad(int edad) {

		this.edad = edad;
	}

	public String getTipoContrato() {

		return tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {

		this.tipoContrato = tipoContrato;
	}

	public int getPuntos() {

		return puntos;
	}

	public void setPuntos(int puntos) {

		this.puntos = puntos;
	}

}
