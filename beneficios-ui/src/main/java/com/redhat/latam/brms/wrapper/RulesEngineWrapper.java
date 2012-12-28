package com.redhat.latam.brms.wrapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.wicket.Session;
import org.drools.KnowledgeBase;
import org.drools.definition.type.FactType;

import com.redhat.claro.engine.domain.RulesEngine;
import com.redhat.latam.brms.model.Cliente;

/**
 * Wrapper para envolver y delegar el comportamiento de crear los objetos
 * declarativo en un unico punto. Tiene una especie de builder. Para poder
 * ejecutar correctamente el wrapper hay que hacerlo de la siguiente manera:
 * <b>new RulesEngineWrapper(engine,cliente,session).withTrivia().execute()</b>
 * o sino <b>new
 * RulesEngineWrapper(engine,cliente,session).withReclamo().execute()</b> para
 * la otra posibilidad
 * 
 * @author aparedes
 * 
 */
public class RulesEngineWrapper {

	private static Logger logger = Logger.getLogger(RulesEngineWrapper.class);
	private RulesEngine engine;
	private Cliente cliente;
	private Session session;
	private FactType triviaType;
	private FactType clienteType;
	private FactType reclamoType;
	private List<Object> engineObjects;
	private Object client;

	public RulesEngineWrapper(RulesEngine engine, Cliente cliente, Session session) {

		this.setEngine(engine);
		this.setCliente(cliente);
		this.setSession(session);

		KnowledgeBase kbase = engine.getAgent().getKnowledgeBase();
		triviaType = kbase.getFactType("beneficios_marketing", "Respuesta_trivia_mkt");
		clienteType = kbase.getFactType("beneficios_marketing", "Cliente_mkt");
		reclamoType = kbase.getFactType("beneficios_marketing", "Reclamo_mkt");
		logger.info(kbase.getKnowledgePackages().size());

		this.client = this.createClient();
		this.engineObjects = new ArrayList<Object>();
		this.engineObjects.add(client);

	}

	public void execute() {

		try {
			logger.info("aca se ejecuta el motor");
			this.getEngine().execute(this.engineObjects);
			getSession().success("Cantidad de SMS otorgados: " + clienteType.get(client, "beneficio_sms"));
			getSession().success("Minutos de VOZ otorgados: " + clienteType.get(client, "beneficio_voz"));
			getSession().success("Cantidad de Puntos otorgados: " + clienteType.get(client, "puntos"));
		} catch (Exception e) {
			getSession().error(e);
		}

	}

	/*
	 * 
	 * BUILDER
	 * 
	 * 
	 */

	public Object createClient() {

		try {

			Object client = clienteType.newInstance();
			clienteType.set(client, "tipo_abono", getCliente().getAbono());
			clienteType.set(client, "beneficio_sms", getCliente().getBeneficioSms());
			clienteType.set(client, "beneficio_voz", getCliente().getBeneficioVoz());
			clienteType.set(client, "edad", getCliente().getEdad());
			clienteType.set(client, "tipo_contrato", getCliente().getContrato());
			clienteType.set(client, "puntos", getCliente().getPuntos());

			return client;

		} catch (InstantiationException e) {
			e.printStackTrace();
			getSession().error(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			getSession().error(e);
		} catch (Exception e) {
			e.printStackTrace();
			getSession().error(e);
		}
		getSession().error("No se puedo crear el cliente");
		return null;
	}

	public RulesEngineWrapper withTrivia() {

		try {

			Object trivia = triviaType.newInstance();
			triviaType.set(trivia, "cliente", client);
			triviaType.set(trivia, "fecha_respuesta", new Date());
			this.engineObjects.add(trivia);

		} catch (InstantiationException e) {
			e.printStackTrace();
			getSession().error(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			getSession().error(e);
		} catch (Exception e) {
			e.printStackTrace();
			getSession().error(e);
		}
		return this;
	}

	public RulesEngineWrapper withReclamo() {

		try {

			Object reclamo = reclamoType.newInstance();
			reclamoType.set(reclamo, "cliente", client);
			reclamoType.set(reclamo, "fecha_reclamo", new Date());
			this.engineObjects.add(reclamo);

		} catch (InstantiationException e) {
			e.printStackTrace();
			getSession().error(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			getSession().error(e);
		} catch (Exception e) {
			e.printStackTrace();
			getSession().error(e);
		}
		return this;
	}

	/*
	 * 
	 * 
	 * ACCESSORS
	 * 
	 * 
	 */
	public RulesEngine getEngine() {

		return engine;
	}

	public void setEngine(RulesEngine engine) {

		this.engine = engine;
	}

	public void setCliente(Cliente cliente) {

		this.cliente = cliente;
	}

	public Cliente getCliente() {

		return this.cliente;
	}

	public Session getSession() {

		return session;
	}

	public void setSession(Session session) {

		this.session = session;
	}

}
