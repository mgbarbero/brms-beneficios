package com.redhat.latam.brms;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import com.redhat.latam.brms.about.AboutPage;
import com.redhat.latam.brms.config.ConfigurationPage;
import com.redhat.latam.brms.home.clientes.ClientesPage;
import com.redhat.latam.brms.model.Cliente;
import com.redhat.latam.brms.reclamo.ReclamoPage;
import com.redhat.latam.brms.trivia.TriviaPage;

public abstract class BasePage extends WebPage {

	private static final long serialVersionUID = 1L;

	public BasePage() {

		add(new Label("session", this.getNombreCliente()));
		add(new BookmarkablePageLink<WebPage>("configuracion", ConfigurationPage.class));
		add(new BookmarkablePageLink<WebPage>("clientes", ClientesPage.class));
		add(new BookmarkablePageLink<WebPage>("trivia", TriviaPage.class));
		add(new BookmarkablePageLink<WebPage>("reclamos", ReclamoPage.class));
		add(new BookmarkablePageLink<WebPage>("about", AboutPage.class));

	}

	public String getNombreCliente() {

		Cliente cliente = ((BeneficiosSession) getSession()).getCliente();
		if (cliente == null) return "";
		else return cliente.getNombre();

	}

	@Override
	public Session getSession() {

		return (BeneficiosSession) super.getSession();
	}

}
