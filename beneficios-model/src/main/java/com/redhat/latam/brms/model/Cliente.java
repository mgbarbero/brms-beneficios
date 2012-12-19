package com.redhat.latam.brms.model;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Transient;

@Entity("clientes")
public class Cliente {

	@Id
	private ObjectId id;

	private String nombre;

	@Transient
	private int beneficioSms;
	@Transient
	private int beneficioVoz;

	private int puntos;
	private String abono;
	private int edad;
	private String contrato;

	private int sms;
	private int voz;

	public ObjectId getId() {

		return this.id;
	}

	public String getAbono() {

		return abono;
	}

	public void setAbono(String tipoAbono) {

		this.abono = tipoAbono;
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

	public String getContrato() {

		return contrato;
	}

	public void setContrato(String tipoContrato) {

		this.contrato = tipoContrato;
	}

	public int getPuntos() {

		return puntos;
	}

	public void setPuntos(int puntos) {

		this.puntos = puntos;
	}

	public String getNombre() {

		return nombre;
	}

	public void setNombre(String nombre) {

		this.nombre = nombre;
	}

	public int getSms() {

		return sms;
	}

	public void setSms(int sms) {

		this.sms = sms;
	}

	public int getVoz() {

		return voz;
	}

	public void setVoz(int voz) {

		this.voz = voz;
	}

	@Override
	public boolean equals(Object obj) {

		Cliente cliente = (Cliente) obj;
		return this.getId().equals(cliente.getId());
	}

}
