package com.redhat.latam.brms.config;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.model.CompoundPropertyModel;

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
				setResponsePage(HomePage.class);
			}
		};

		form.add(new RequiredTextField<Integer>("refreshTime"));
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
