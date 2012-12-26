package com.redhat.claro.engine.domain;

// TODO mover a otro paquete

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.drools.agent.KnowledgeAgent;
import org.drools.agent.KnowledgeAgentConfiguration;
import org.drools.agent.KnowledgeAgentFactory;
import org.drools.event.DebugProcessEventListener;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatelessKnowledgeSession;

import com.redhat.claro.engine.config.Configuration;
import com.redhat.claro.engine.domain.listeners.RedHatAgendaListener;
import com.redhat.claro.engine.domain.listeners.RedHatKnowledgeAgentEventListener;
import com.redhat.claro.engine.domain.listeners.RedHatWorkingMemoryListener;

/**
 * Motor de reglas basado en Change Set para poder buscar la fuente de
 * conocimientos
 * 
 * @author aparedes
 * 
 */
public class RulesEngine {

	private String changeSet;
	private KnowledgeAgent agent;
	private String name;
	private KnowledgeRuntimeLogger rulesLogger;
	private static Logger logger = Logger.getLogger(RulesEngine.class);

	public RulesEngine(String name, String changeSet) {

		this.name = name;
		this.setChangeSet(changeSet);

	}

	public String getName() {

		return this.name;
	}

	/**
	 * Ejecuta el motor de reglas recibiendo todo el conjunto de objetos
	 * necesarios.
	 * 
	 * @param objects
	 */
	public void execute(List<?> objects) {

		StatelessKnowledgeSession session = this.getSession();
		session.execute(objects);
		logger.info("Se han ejecutado las reglas de negocio");
		rulesLogger.close();
	}

	public void execute(List<?> objects, Map<String, Object> globals) {

		StatelessKnowledgeSession session = this.getSession();
		this.setGlobals(session, globals);
		session.execute(objects);
		this.rulesLogger.close();
	}

	private void setGlobals(StatelessKnowledgeSession session, Map<String, Object> globals) {

		if (globals != null) {
			for (Entry<String, Object> entry : globals.entrySet()) {
				session.setGlobal(entry.getKey(), entry.getValue());
			}
		}
	}

	public String getChangeSet() {

		return this.changeSet;
	}

	public void setChangeSet(String fileName) {

		this.changeSet = fileName;
	}

	public StatelessKnowledgeSession getSession() {

		StatelessKnowledgeSession session = this.getAgent().newStatelessKnowledgeSession();
		session.addEventListener(new RedHatWorkingMemoryListener());
		session.addEventListener(new RedHatAgendaListener());
		session.addEventListener(new DebugProcessEventListener());
		this.rulesLogger = KnowledgeRuntimeLoggerFactory.newConsoleLogger(session);
		return session;
	}

	/**
	 * Si el agente no esta instanciado en el motor lo crea teniendo en cuenta
	 * el change set especificado en el constructor de la clase
	 * 
	 * @return
	 */
	public KnowledgeAgent getAgent() {

		if (this.agent == null) {

			// KnowledgeBase base = KnowledgeBaseFactory.newKnowledgeBase();
			// logger.info("No existe el agente, se lo creara");
			// this.agent = KnowledgeAgentFactory.newKnowledgeAgent("Agent",
			// base, this.getConfiguration());

			this.agent = KnowledgeAgentFactory.newKnowledgeAgent("Agent",
					this.getConfiguration());

			logger.info("Se aplica el changeset");
			agent.addEventListener(new RedHatKnowledgeAgentEventListener());
			agent.applyChangeSet(ResourceFactory.newFileResource(this.getChangeSet()));

			logger.info("Se creo el agente, se inician los servicios");
			ResourceFactory.getResourceChangeNotifierService().start();
			ResourceFactory.getResourceChangeScannerService().start();
		}
		return this.agent;
	}

	protected KnowledgeAgentConfiguration getConfiguration() {

		KnowledgeAgentConfiguration conf = KnowledgeAgentFactory.newKnowledgeAgentConfiguration();
		conf.setProperty("drools.resource.scanner.interval", Configuration.instance().get("drools.resource.scanner.interval"));
		logger.info("Refresh Time: " + Configuration.instance().get("drools.resource.scanner.interval"));

		return conf;
	}

}
