package com.redhat.latam.brms.about;

import org.apache.wicket.markup.html.basic.Label;

import com.redhat.claro.engine.config.Configuration;
import com.redhat.latam.brms.BasePage;

public class AboutPage extends BasePage {

	private static final long serialVersionUID = 3933761211141354959L;

	public AboutPage() {

	}

	@Override
	protected void onInitialize() {

		super.onInitialize();
		add(new Label("refresh", Configuration.instance().get("drools.resource.scanner.interval")));
		add(new Label("usuario", this.getNombreCliente()));
		add(new Label("changeset", Configuration.instance().get("changeSet")));
	}

}
