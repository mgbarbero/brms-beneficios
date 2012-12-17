package com.redhat.claro.engine.domain.listeners;

import org.apache.log4j.Logger;
import org.drools.event.rule.ActivationCancelledEvent;
import org.drools.event.rule.ActivationCreatedEvent;
import org.drools.event.rule.AfterActivationFiredEvent;
import org.drools.event.rule.BeforeActivationFiredEvent;
import org.drools.event.rule.DefaultAgendaEventListener;

public class RedHatAgendaListener extends DefaultAgendaEventListener{

	private static Logger logger = Logger.getLogger(RedHatAgendaListener.class);

	@Override
	public void beforeActivationFired(BeforeActivationFiredEvent event) {

		String ruleName = event.getActivation().getRule().getName();
		logger.info("[BEFORE-ACTIVATION] Rule: " + ruleName);
	}

	@Override
	public void afterActivationFired(AfterActivationFiredEvent event) {

		String ruleName = event.getActivation().getRule().getName();
		logger.info("[AFTER-ACTIVATION-FIRED] Rule: " + ruleName);
	}

	@Override
	public void activationCreated(ActivationCreatedEvent event) {

		String ruleName = event.getActivation().getRule().getName();
		logger.info("[ACTIVATION-CREATED] Rule: " + ruleName);
	}
	
	@Override
	public void activationCancelled(ActivationCancelledEvent event) {
	
		String ruleName = event.getActivation().getRule().getName();
		logger.info("[ACTIVATION-CANCELLED] Rule: " + ruleName);
	}

}