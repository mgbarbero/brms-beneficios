package com.redhat.claro.engine.domain.listeners;

import org.apache.log4j.Logger;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.event.knowledgeagent.AfterChangeSetAppliedEvent;
import org.drools.event.knowledgeagent.AfterChangeSetProcessedEvent;
import org.drools.event.knowledgeagent.AfterResourceProcessedEvent;
import org.drools.event.knowledgeagent.BeforeChangeSetAppliedEvent;
import org.drools.event.knowledgeagent.BeforeChangeSetProcessedEvent;
import org.drools.event.knowledgeagent.BeforeResourceProcessedEvent;
import org.drools.event.knowledgeagent.KnowledgeAgentEventListener;
import org.drools.event.knowledgeagent.KnowledgeBaseUpdatedEvent;
import org.drools.event.knowledgeagent.ResourceCompilationFailedEvent;

public class RedHatKnowledgeAgentEventListener implements
		KnowledgeAgentEventListener {

	private static Logger logger = Logger.getLogger(RedHatKnowledgeAgentEventListener.class);

	@Override
	public void afterChangeSetApplied(AfterChangeSetAppliedEvent arg0) {

		String operation = "AFTER-CHANGE-SET-APPLIED";
		logger.info(operation + ": " + arg0.getChangeSet().getResourcesAdded().size());
	}

	@Override
	public void afterChangeSetProcessed(AfterChangeSetProcessedEvent arg0) {

		String operation = "AFTER-CHANGE-SET-PROCESSED";
		logger.info(operation + ": " + arg0.getChangeSet().getResourcesAdded().size());

	}

	@Override
	public void afterResourceProcessed(AfterResourceProcessedEvent arg0) {

		String operation = "AFTER-RESOURCE-PROCESSED";
		logger.info(operation + ": " + arg0.getChangeSet().getResourcesAdded().size());

	}

	@Override
	public void beforeChangeSetApplied(BeforeChangeSetAppliedEvent arg0) {

		String operation = "BEFORE-CHANGE-SET-APPLIED";
		logger.info(operation + ": " + arg0.getChangeSet().getResourcesAdded().size());
	}

	@Override
	public void beforeChangeSetProcessed(BeforeChangeSetProcessedEvent arg0) {

		String operation = "BEFORE-CHANGE-SET-APPLIED";
		logger.info(operation + ": " + arg0.getChangeSet().getResourcesAdded().size());
	}

	@Override
	public void beforeResourceProcessed(BeforeResourceProcessedEvent arg0) {

		String operation = "BEFORE-RESOURCE-PROCESSED";
		logger.info(operation + ": " + arg0.getChangeSet().getResourcesAdded().size());
	}

	@Override
	public void knowledgeBaseUpdated(KnowledgeBaseUpdatedEvent arg0) {

		String operation = "KNOWLEDGE-BASE-UPDATED";
		logger.info(operation + ": " + arg0.getSource().toString());
	}

	@Override
	public void resourceCompilationFailed(ResourceCompilationFailedEvent arg0) {

		for (KnowledgeBuilderError error : arg0.getKnowledgeBuilder().getErrors()) {
			logger.error("[COMPILATION]: " + error);
		}
	}
}
