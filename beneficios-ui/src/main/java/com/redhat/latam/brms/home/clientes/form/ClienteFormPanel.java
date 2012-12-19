package com.redhat.latam.brms.home.clientes.form;

import java.util.Observer;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

import com.redhat.latam.brms.model.Cliente;

public class ClienteFormPanel extends Panel {

	private static final long serialVersionUID = 1590056133838506962L;

	private Cliente model;
	private Observer observer;

	public ClienteFormPanel(String id, Cliente cliente, Observer observer) {

		super(id);
		this.setModel(cliente);
		this.setObserver(observer);
		add(this.createForm());
	}

	public Form<Cliente> createForm() {

		Form<Cliente> form = new Form<Cliente>("form", new CompoundPropertyModel<Cliente>(this.getModel())) {

			@Override
			protected void onSubmit() {

				observer.update(null, getModelObject());
			}
		};
		form.add(new RequiredTextField<String>("nombre"));
		form.add(new RequiredTextField<String>("abono"));
		form.add(new RequiredTextField<String>("contrato"));
		form.add(new RequiredTextField<Integer>("edad"));
		form.add(new RequiredTextField<Integer>("sms"));
		form.add(new RequiredTextField<Integer>("voz"));
		form.add(new RequiredTextField<Integer>("puntos"));
		return form;
	}

	public Cliente getModel() {

		return model;
	}

	public void setModel(Cliente model) {

		this.model = model;
	}

	public Observer getObserver() {

		return observer;
	}

	public void setObserver(Observer observer) {

		this.observer = observer;
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

}
