package com.redhat.latam.brms.trivia;

import java.util.Arrays;
import java.util.Date;

import org.apache.wicket.markup.html.form.Form;
import org.drools.KnowledgeBase;
import org.drools.definition.type.FactType;

import com.redhat.claro.engine.config.Configuration;
import com.redhat.claro.engine.domain.RulesChangeSet;
import com.redhat.claro.engine.domain.RulesEngine;
import com.redhat.claro.engine.domain.RulesEngineFactory;
import com.redhat.latam.brms.BasePage;
import com.redhat.latam.brms.model.Configuracion;
import com.redhat.latam.brms.model.Respuesta;

public class TriviaPage extends BasePage {

	private static final long serialVersionUID = -4367627401630576797L;

	public TriviaPage() {

		Form<Respuesta> form = new Form<Respuesta>("form") {

			protected void onSubmit() {

				// ACA SE EJECUTA EL MOTOR DE REGLAS
				System.out.println("aca se ejecuta el motor");
				RulesEngine engine = RulesEngineFactory.getEngine(new RulesChangeSet("beneficios", getChangeset()));
				engine.setChangeSet(getChangeset());

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

				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			private String getChangeset() {

				return Configuration.instance().get("changeset");
			}

		};

		add(form);
	}
}
