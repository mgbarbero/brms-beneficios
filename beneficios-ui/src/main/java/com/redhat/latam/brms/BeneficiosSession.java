package com.redhat.latam.brms;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

import com.redhat.latam.brms.model.Cliente;

public class BeneficiosSession extends WebSession {

	private static final long serialVersionUID = -2878973468754135210L;
	private Cliente cliente;

	public BeneficiosSession(Request request) {

		super(request);
	}

	public Cliente getCliente() {

		return cliente;
	}

	public void setCliente(Cliente cliente) {

		this.cliente = cliente;
	}

}
