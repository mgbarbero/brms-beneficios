package com.redhat.latam.brms;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import com.redhat.latam.brms.config.ConfigurationPage;

public abstract class BasePage extends WebPage {

	private static final long serialVersionUID = 1L;

	public BasePage() {
		
		add(new BookmarkablePageLink<WebPage>("configuracion", ConfigurationPage.class));

    }
}
