package com.redhat.latam.brms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.redhat.latam.brms.model.Cliente;
import com.redhat.latam.brms.repository.Repository;

/**
 * Unit test for simple App.
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

}
