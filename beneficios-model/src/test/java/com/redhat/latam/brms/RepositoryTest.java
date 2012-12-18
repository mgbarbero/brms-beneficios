package com.redhat.latam.brms;

import static org.junit.Assert.*;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;

import com.redhat.latam.brms.model.Cliente;
import com.redhat.latam.brms.repository.Repository;

/**
 * Bateria de tests para probar la persistencia
 * 
 * @author aparedes
 * 
 */
public class RepositoryTest {

	Repository repository;

	@Before
	public void setUp() {

		repository = new Repository("test");
		repository.truncate(Cliente.class);

	}

	@Test
	public void guardoUnClienteYSeMantieneEnLaBaseDeDatos() {

		Cliente cliente = new Cliente();
		repository.truncate(Cliente.class);
		repository.save(cliente);
		assertEquals(1, repository.size(Cliente.class));
	}

	@Test
	public void truncarLaBaseDeDatos() {

		Cliente cliente = new Cliente();
		repository.save(cliente);
		repository.truncate(Cliente.class);
		assertEquals(0, repository.size(Cliente.class));
	}

	@Test
	public void guardoUnClienteConValoresYLoBusco() {

		Cliente cliente = new Cliente();
		cliente.setBeneficioSms(100);
		repository.truncate(Cliente.class);
		repository.save(cliente);
		ObjectId id = cliente.getId();
		assertEquals(100, repository.find(Cliente.class, id).getBeneficioSms());
	}

}
