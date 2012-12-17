package com.redhat.claro.engine.domain;

import java.util.HashMap;
import java.util.Map;

import com.redhat.claro.engine.domain.RulesChangeSet;

/**
 * Es el encargado de tener el pool de motores de regla dentro del sistema. Va a
 * existir un motor de reglas por cada uno de los paquetes de reglas necesarios
 * para poder utilizar el motor.
 * 
 * @author aparedes
 * 
 */
public final class RulesEngineFactory {

	private static Map<String, RulesEngine> map = new HashMap<String, RulesEngine>();

	public static RulesEngine getEngine(RulesChangeSet changeSet) {

		if (!map.containsKey(changeSet.getId())) {
			map.put(changeSet.getId(), new RulesEngine(changeSet.getId(), changeSet.getFileName()));
		}
		return map.get(changeSet.getId());
	}

	private RulesEngineFactory() {

	}
}
