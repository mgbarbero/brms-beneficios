package com.redhat.latam.brms.home.clientes.form;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import com.redhat.latam.brms.model.Cliente;

public class ClienteForm extends FormComponentPanel<Cliente> {

	public ClienteForm(String id, Cliente cliente) {

		super(id);
		CompoundPropertyModel<Cliente> clienteModel = new CompoundPropertyModel<Cliente>(cliente);
		this.setModel(clienteModel);
		add(this.createForm());

	}

	public Form<Cliente> createForm() {

		Form<Cliente> form = new Form<Cliente>("form");
		return form;
	}

	private static final long serialVersionUID = 1590056133838506962L;

}
