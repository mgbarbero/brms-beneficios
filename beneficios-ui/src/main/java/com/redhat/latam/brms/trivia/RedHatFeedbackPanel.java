package com.redhat.latam.brms.trivia;

import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

public class RedHatFeedbackPanel extends FeedbackPanel {

	private static final long serialVersionUID = -5040618212402404081L;

	public RedHatFeedbackPanel(String id) {

		super(id);
	}

	@Override
	protected String getCSSClass(FeedbackMessage message) {

		if (message.getLevel() == message.INFO)
			return "alert unstyled alert-info";
		if (message.getLevel() == message.SUCCESS)
			return "alert unstyled alert-success";
		if (message.getLevel() == message.ERROR) return "alert unstyled alert-error";

		else return "alert unstyled ";
	}

}
