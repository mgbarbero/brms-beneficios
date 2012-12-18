package com.redhat.latam.brms.model;

public class Cliente {

	private String tipoAbono;
	private int beneficioSms;
	private int beneficioVoz;
	private int edad;
	private String tipoContrato;
	private int puntos;

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
