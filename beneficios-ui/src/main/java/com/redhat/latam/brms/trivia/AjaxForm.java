package com.redhat.latam.brms.trivia;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.form.Form;

import com.redhat.claro.engine.config.Configuration;
import com.redhat.claro.engine.domain.RulesEngine;
import com.redhat.latam.brms.model.Cliente;
import com.redhat.latam.brms.model.Respuesta;
import com.redhat.latam.brms.wrapper.RulesEngineWrapper;

public class AjaxForm extends Form<Respuesta> {

	private static final long serialVersionUID = -4419605589163184602L;
	private Cliente cliente;
	private static Logger logger = Logger.getLogger(AjaxForm.class);

	public AjaxForm(String id, Cliente cliente) {

		super(id);
		this.setCliente(cliente);

	}

	private void setCliente(Cliente cliente) {

		this.cliente = cliente;
	}

	private Cliente getCliente() {

		return this.cliente;
	}

	@Override
	protected void onSubmit() {

		logger.info("aca se ejecuta el motor");
		RulesEngine engine = new RulesEngine("beneficios", getChangeset());
		new RulesEngineWrapper(engine, getCliente(), getSession()).withTrivia().execute();

	}

	private String getChangeset() {

		return Configuration.instance().get("changeset");
	}

}
