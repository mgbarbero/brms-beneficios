package com.redhat.latam.brms;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import com.redhat.latam.brms.config.ConfigurationPage;
import com.redhat.latam.brms.home.clientes.ClientesPage;

public abstract class BasePage extends WebPage {

	private static final long serialVersionUID = 1L;

	public BasePage() {

		add(new BookmarkablePageLink<WebPage>("configuracion", ConfigurationPage.class));
		add(new BookmarkablePageLink<WebPage>("clientes", ClientesPage.class));

	}
}
