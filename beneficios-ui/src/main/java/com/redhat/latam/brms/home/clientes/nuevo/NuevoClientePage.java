package com.redhat.latam.brms.home.clientes.nuevo;

import java.util.Observable;
import java.util.Observer;

import com.redhat.latam.brms.BasePage;
import com.redhat.latam.brms.home.clientes.ClientesPage;
import com.redhat.latam.brms.home.clientes.form.ClienteFormPanel;
import com.redhat.latam.brms.model.Cliente;
import com.redhat.latam.brms.repository.Repository;

public class NuevoClientePage extends BasePage {

	private static final long serialVersionUID = -2126110149248219711L;

	public NuevoClientePage() {

		ClienteFormPanel clienteForm = new ClienteFormPanel("formPanel", new Cliente(), this.onSubmit());
		add(clienteForm);

	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	private Observer onSubmit() {

		return new Observer() {

			@Override
			public void update(Observable o, Object arg) {

				Cliente cliente = (Cliente) arg;
				Repository.getInstance().save(cliente);
				setResponsePage(ClientesPage.class);
			}

		};
	}

}
