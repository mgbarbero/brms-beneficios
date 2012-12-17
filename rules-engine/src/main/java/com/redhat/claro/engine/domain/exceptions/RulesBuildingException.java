package com.redhat.claro.engine.domain.exceptions;

import org.apache.log4j.Logger;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;

public class RulesBuildingException extends RuntimeException {

	private static final long serialVersionUID = -3115322393022989146L;
	private Logger logger = Logger.getLogger(RulesBuildingException.class);
	private final String errorMessage = "No se pudo construir corectamente las reglas de negocio";
	private final String header = "[RULES-ENGINE] ";

	public RulesBuildingException(KnowledgeBuilderErrors buildingErrors) {

		super("No se pudo construir corectamente las reglas de negocio");
		logger.error(this.header + this.errorMessage);
		for (KnowledgeBuilderError knowledgeBuilderError : buildingErrors) {
			logger.error(this.header + knowledgeBuilderError);
		}
	}
}
