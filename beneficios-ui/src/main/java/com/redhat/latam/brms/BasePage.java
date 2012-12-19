package com.redhat.latam.brms;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import com.redhat.latam.brms.config.ConfigurationPage;
import com.redhat.latam.brms.home.clientes.ClientesPage;
import com.redhat.latam.brms.model.Cliente;

public abstract class BasePage extends WebPage {

	private static final long serialVersionUID = 1L;

	public BasePage() {

		add(new Label("session", this.getNombreCliente()));
		add(new BookmarkablePageLink<WebPage>("configuracion", ConfigurationPage.class));
		add(new BookmarkablePageLink<WebPage>("clientes", ClientesPage.class));

	}

	public String getNombreCliente() {

		Cliente cliente = ((BeneficiosSession) getSession()).getCliente();
		if (cliente == null) return "";
		else return cliente.getNombre();

	}
}
