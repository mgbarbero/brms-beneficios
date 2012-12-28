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
import com.redhat.latam.brms.wrapper.RulesEngineWrapper;

public class ReclamoPage extends BasePage {

	private static final long serialVersionUID = -1241080836097764436L;

	public ReclamoPage() {

		Form<Cliente> form = new Form<Cliente>("form") {

			@Override
			protected void onSubmit() {

				// ACA SE EJECUTA EL MOTOR DE REGLAS
				System.out.println("aca se ejecuta el motor");
				RulesEngine engine = new RulesEngine("beneficios", getChangeset());
				new RulesEngineWrapper(engine, getCliente(), getSession()).withReclamo().execute();
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
