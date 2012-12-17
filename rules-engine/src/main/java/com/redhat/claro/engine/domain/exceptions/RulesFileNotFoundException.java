package com.redhat.claro.engine.domain.exceptions;


public class RulesFileNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8696300787534553489L;
	
	
	public RulesFileNotFoundException(Throwable cause) {
		super("El archivo especificado en el change set no se encuentra disponible. Compruebe la ruta al archivo",cause);
	}

}
