package com.redhat.latam.brms.trivia;

import java.util.Arrays;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;
import org.drools.KnowledgeBase;
import org.drools.definition.type.FactType;

import com.redhat.claro.engine.config.Configuration;
import com.redhat.claro.engine.domain.RulesEngine;
import com.redhat.latam.brms.model.Cliente;
import com.redhat.latam.brms.model.Respuesta;

public class AjaxForm extends Form<Respuesta> {

	private static final long serialVersionUID = -4419605589163184602L;
	private Cliente cliente;
	private static Logger logger = Logger.getLogger(AjaxForm.class);

	public AjaxForm(String id, Cliente cliente) {

		super(id);
		this.setCliente(cliente);

	}

	private void setCliente(Cliente cliente) {

		this.cliente = cliente;
	}

	private Cliente getCliente() {

		return this.cliente;
	}

	@Override
	protected void onSubmit() {

		// ACA SE EJECUTA EL MOTOR DE REGLAS
		System.out.println("aca se ejecuta el motor");
		RulesEngine engine = new RulesEngine("beneficios", getChangeset());
		// engine.setChangeSet(getChangeset());

		KnowledgeBase kbase = engine.getAgent().getKnowledgeBase();
		System.out.println(kbase.getKnowledgePackages().size());
		FactType triviaType = kbase.getFactType("beneficios_marketing", "Respuesta_trivia_mkt");
		FactType clienteType = kbase.getFactType("beneficios_marketing", "Cliente_mkt");

		try {
			Object trivia = triviaType.newInstance();
			Object cliente = clienteType.newInstance();

			clienteType.set(cliente, "tipo_abono", getCliente().getAbono());
			clienteType.set(cliente, "beneficio_sms", getCliente().getBeneficioSms());
			clienteType.set(cliente, "beneficio_voz", getCliente().getBeneficioVoz());
			clienteType.set(cliente, "edad", getCliente().getEdad());
			clienteType.set(cliente, "tipo_contrato", getCliente().getContrato());
			clienteType.set(cliente, "puntos", getCliente().getPuntos());

			triviaType.set(trivia, "cliente", cliente);
			triviaType.set(trivia, "fecha_respuesta", new Date());

			engine.execute(Arrays.asList(trivia, cliente));
			getSession().success("Satisfactorio");

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getSession().error(e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getSession().error(e);
		} catch (Exception e) {
			e.printStackTrace();
			getSession().error(e);
		}

	}

	private String getChangeset() {

		return Configuration.instance().get("changeset");
	}

}
