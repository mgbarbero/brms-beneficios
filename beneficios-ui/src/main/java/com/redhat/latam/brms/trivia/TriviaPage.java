package com.redhat.latam.brms.trivia;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;

import com.redhat.latam.brms.BasePage;
import com.redhat.latam.brms.model.Respuesta;

public class TriviaPage extends BasePage {

	private static final long serialVersionUID = -4367627401630576797L;
	private String pregunta = "";

	public TriviaPage() {

		Form<Respuesta> form = new AjaxForm("form", getCliente());
		form.add(new TextField<String>("pregunta", new Model<String>(this.pregunta)));
		FeedbackPanel feedback = new RedHatFeedbackPanel("feedback");
		add(feedback);
		add(form);

	}
}
