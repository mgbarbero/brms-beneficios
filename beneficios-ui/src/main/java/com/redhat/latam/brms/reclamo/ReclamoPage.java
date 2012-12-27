package com.redhat.latam.brms.reclamo;

import java.util.Arrays;
import java.util.Date;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.drools.KnowledgeBase;
import org.drools.definition.type.FactType;

import com.redhat.claro.engine.config.Configuration;
import com.redhat.claro.engine.domain.RulesEngine;
import com.redhat.latam.brms.BasePage;
import com.redhat.latam.brms.model.Cliente;
import com.redhat.latam.brms.trivia.RedHatFeedbackPanel;

public class ReclamoPage extends BasePage {

	private static final long serialVersionUID = -1241080836097764436L;

	public ReclamoPage() {

		Form<Cliente> form = new Form<Cliente>("form") {

			@Override
			protected void onSubmit() {

				// ACA SE EJECUTA EL MOTOR DE REGLAS
				System.out.println("aca se ejecuta el motor");
				RulesEngine engine = new RulesEngine("beneficios", getChangeset());
				// engine.setChangeSet(getChangeset());

				KnowledgeBase kbase = engine.getAgent().getKnowledgeBase();
				System.out.println(kbase.getKnowledgePackages().size());
				FactType reclamoType = kbase.getFactType("beneficios_marketing", "Reclamo_mkt");
				FactType clienteType = kbase.getFactType("beneficios_marketing", "Cliente_mkt");

				try {
					Object reclamo = reclamoType.newInstance();
					Object cliente = clienteType.newInstance();

					clienteType.set(cliente, "tipo_abono", getCliente().getAbono());
					clienteType.set(cliente, "beneficio_sms", getCliente().getBeneficioSms());
					clienteType.set(cliente, "beneficio_voz", getCliente().getBeneficioVoz());
					clienteType.set(cliente, "edad", getCliente().getEdad());
					clienteType.set(cliente, "tipo_contrato", getCliente().getContrato());
					clienteType.set(cliente, "puntos", getCliente().getPuntos());

					reclamoType.set(reclamo, "cliente", cliente);
					reclamoType.set(reclamo, "fecha_reclamo", new Date());

					engine.execute(Arrays.asList(reclamo, cliente));
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

		};

		FeedbackPanel feedback = new RedHatFeedbackPanel("feedback");
		add(feedback);
		add(form);
	}
}
