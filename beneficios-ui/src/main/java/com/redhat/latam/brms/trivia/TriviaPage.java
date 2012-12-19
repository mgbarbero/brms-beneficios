package com.redhat.latam.brms.trivia;

import org.apache.wicket.markup.html.form.Form;

import com.redhat.latam.brms.BasePage;
import com.redhat.latam.brms.model.Respuesta;

public class TriviaPage extends BasePage {

	private static final long serialVersionUID = -4367627401630576797L;

	public TriviaPage() {

		Form<Respuesta> form = new Form<Respuesta>("form") {

			protected void onSubmit() {

				// ACA SE EJECUTA EL MOTOR DE REGLAS
				System.out.println("aca se ejecuta el motor");
			};
		};

		add(form);
	}
}
