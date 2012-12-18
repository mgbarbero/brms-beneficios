package com.redhat.latam.brms.repository;

import java.net.UnknownHostException;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.redhat.latam.brms.model.Cliente;
import com.redhat.latam.brms.model.Configuracion;
import com.redhat.latam.brms.model.Reclamo;
import com.redhat.latam.brms.model.Respuesta;

/**
 * Se encarga de almacenar todos los objetos. Debajo tiene una implementación en
 * mongodb para poder persistir todos los objetos de dominio
 * 
 * @author aparedes
 * 
 */
public class Repository {

	private static final Repository instance = new Repository();

	public static Repository getInstance() {

		return instance;
	}

	/*
	 * 
	 */

	private Datastore dataStore;

	public Repository() {

		this.setDataStore(this.createDataStoreByScope("development"));

	}

	public Repository(String scope) {

		this.setDataStore(this.createDataStoreByScope(scope));

	}

	public void save(Object object) {

		this.getDataStore().save(object);
	}

	public <T> long size(Class<T> clazz) {

		return this.getDataStore().getCount(clazz);
	}

	public <T> void truncate(Class<T> clazz) {

		this.getDataStore().getCollection(clazz).drop();
	}

	public <T> T find(Class<T> clazz, String field, String value) {

		return this.getDataStore().find(clazz).field(field).equal(value).get();
	}

	public <T> T find(Class<T> clazz, ObjectId id) {

		return this.getDataStore().get(clazz, id);
	}
	
	public <T> T find(Class<T> clazz) {

		return this.getDataStore().find(clazz).get();
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	private Datastore createDataStoreByScope(String scope) {

		Mongo mongo = this.getMongo();
		Morphia morphia = new Morphia();
		morphia.map(Respuesta.class).map(Cliente.class).map(Reclamo.class).map(Configuracion.class);

		if ("development".toLowerCase().equals(scope.toLowerCase()))
			return morphia.createDatastore(mongo, "beneficios_dev");
		if ("test".toLowerCase().equals(scope.toLowerCase()))
			return morphia.createDatastore(mongo, "beneficios_test");
		if ("production".toLowerCase().equals(scope.toLowerCase()))
			return morphia.createDatastore(mongo, "beneficios_prod");

		throw new RuntimeException("No se ha podido crear la base de datos");

	}

	private Mongo getMongo() {

		try {
			return new Mongo();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new RuntimeException("No se pudo instanciar MongoDB");
	}

	public Datastore getDataStore() {

		return dataStore;
	}

	public void setDataStore(Datastore dataStore) {

		this.dataStore = dataStore;
	}



}
