package com.redhat.claro.engine.domain;

import com.redhat.claro.engine.config.Configuration;

/**
 * Representa de una forma mucho mas facil los nombres de los motores de reglas
 * en conjunto a su respectivo changeset. Cualquier nuevo changset que se
 * necesite dentro del sistema deberá ser especificado aqui dentro
 * 
 * @author aparedes
 * 
 */
public class RulesChangeSet{


	private String property;
	private String id;

	public RulesChangeSet(String id, String property) {

		this.id = id;
		this.property = property;

	}

	public String getId() {

		return this.id;
	}

	public String getFileName() {

		return Configuration.instance().get(this.property);
	}


}
