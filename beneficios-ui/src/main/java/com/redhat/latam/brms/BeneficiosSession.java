package com.redhat.latam.brms;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

import com.redhat.claro.engine.config.Configuration;
import com.redhat.latam.brms.model.Cliente;
import com.redhat.latam.brms.model.Configuracion;
import com.redhat.latam.brms.repository.Repository;

public class BeneficiosSession extends WebSession {

	private static final long serialVersionUID = -2878973468754135210L;
	private Cliente cliente;

	public BeneficiosSession(Request request) {

		super(request);
		this.loadConfiguration();

	}

	private void loadConfiguration() {

		Configuracion config = Repository.getInstance().find(Configuracion.class);
		Configuration.instance().put("drools.resource.scanner.interval", config.getRefreshTime());
		Configuration.instance().put("changeset", config.getChangeSet());
	}

	public Cliente getCliente() {

		return cliente;
	}

	public void setCliente(Cliente cliente) {

		this.cliente = cliente;
	}

}
