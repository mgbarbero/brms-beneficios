package com.redhat.claro.engine.domain.listeners;

import org.apache.log4j.Logger;
import org.drools.event.rule.DefaultWorkingMemoryEventListener;
import org.drools.event.rule.ObjectInsertedEvent;
import org.drools.event.rule.ObjectRetractedEvent;
import org.drools.event.rule.ObjectUpdatedEvent;

public class RedHatWorkingMemoryListener extends
		DefaultWorkingMemoryEventListener {

	private static Logger logger = Logger.getLogger(RedHatWorkingMemoryListener.class);

	@Override
	public void objectInserted(ObjectInsertedEvent event) {

		String className = event.getObject().getClass().getSimpleName();
		logger.info("[OBJECT INSERTED]: " + className);
	}

	@Override
	public void objectRetracted(ObjectRetractedEvent event) {

		String className = event.getOldObject().getClass().getSimpleName();
		logger.info("[OBJECT RETRACTED]: " + className);
	}

	@Override
	public void objectUpdated(ObjectUpdatedEvent event) {

		String oldObject = event.getOldObject().getClass().getSimpleName();
		String newObject = event.getObject().getClass().getSimpleName();
		logger.info("[OBJECT UPDATED]: " + oldObject + " TO " + newObject);
	}
	
	
}
