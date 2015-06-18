package eus.ehu.patrondao.modelo.dbms;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import eus.ehu.patrondao.bean.Alumno;

public class AlDAOTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	AlDAO alumdao = null;

	@Test
	public void getById() {
		Alumno al = this.alumdao.getById(0);
		final Alumno alum = new Alumno();
		alum.setId(0);
		alum.setNombre("Juan0");
		Assert.assertEquals("Los alumnos no son iguales", alum, al);

		al = this.alumdao.getById(1);

		Assert.assertNotEquals("Los alumnos son iguales", alum, al);

	}

	@Before
	public void setUp() throws Exception {
		this.alumdao = new AlDAO();
	}

	@After
	public void tearDown() throws Exception {
		this.alumdao = null;
	}

}
