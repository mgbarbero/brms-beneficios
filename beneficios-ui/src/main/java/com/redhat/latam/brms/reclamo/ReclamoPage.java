package com.redhat.latam.brms.reclamo;

import org.apache.wicket.markup.html.form.Form;

import com.redhat.latam.brms.BasePage;
import com.redhat.latam.brms.model.Cliente;

public class ReclamoPage extends BasePage {

	private static final long serialVersionUID = -1241080836097764436L;

	public ReclamoPage() {

		Form<Cliente> form = new Form<Cliente>("form") {

		};

		add(form);
	}
}
