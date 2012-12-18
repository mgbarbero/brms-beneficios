package com.redhat.latam.brms.home.clientes.nuevo;

import com.redhat.latam.brms.BasePage;
import com.redhat.latam.brms.home.clientes.form.ClienteForm;
import com.redhat.latam.brms.model.Cliente;

public class NuevoClientePage extends BasePage {

	private static final long serialVersionUID = -2126110149248219711L;

	public NuevoClientePage() {

		add(new ClienteForm("form", new Cliente()));
	}
}
