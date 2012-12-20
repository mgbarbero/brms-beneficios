package com.redhat.latam.brms.config;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.model.CompoundPropertyModel;

import com.redhat.claro.engine.config.Configuration;
import com.redhat.claro.engine.domain.RulesChangeSet;
import com.redhat.claro.engine.domain.RulesEngine;
import com.redhat.claro.engine.domain.RulesEngineFactory;
import com.redhat.latam.brms.BasePage;
import com.redhat.latam.brms.home.HomePage;
import com.redhat.latam.brms.model.Configuracion;
import com.redhat.latam.brms.repository.Repository;

public class ConfigurationPage extends BasePage {

	public ConfigurationPage() {

		Form<Configuracion> form = this.createForm();

		add(form);
	}

	public Form<Configuracion> createForm() {

		Configuracion configuracion = getConfiguration();
		CompoundPropertyModel<Configuracion> model = new CompoundPropertyModel<Configuracion>(configuracion);

		Form<Configuracion> form = new Form<Configuracion>("form", model) {

			@Override
			protected void onSubmit() {

				Configuracion config = this.getModelObject();
				Repository.getInstance().save(config);

				Configuration.instance().put("drools.resource.scanner.interval", config.getRefreshTime());
				Configuration.instance().put("changeset", config.getChangeSet());

				setResponsePage(HomePage.class);
			}
		};

		form.add(new RequiredTextField<String>("refreshTime"));
		form.add(new RequiredTextField<String>("changeSet"));
		return form;

	}

	private Configuracion getConfiguration() {

		Configuracion config = Repository.getInstance().find(Configuracion.class);
		if (config == null) return new Configuracion();
		else return config;
	}

	private static final long serialVersionUID = -8592944648539164875L;

}
