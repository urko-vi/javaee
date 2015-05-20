package com.ipartek.formacion.helloweb.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.helloweb.bean.Persona;

public class ModeloPersonaTest {

    ModeloPersona model = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {

    }

    @Before
    public void setUp() throws Exception {

	model = new ModeloPersona();
	ModeloPersona.createTable();

    }

    @After
    public void tearDown() throws Exception {
	ModeloPersona.truncateTable();
	model = null;
    }

    @Test
    public void testGetAll() throws Exception {
	assertEquals(5, model.getAll().size());
	ModeloPersona.truncateTable();
	assertNull(model.getAll());
    }

    @Test
    public void testGetById() throws Exception {

	String nombre = "Gorriti2";
	int idNuevo = model.insert(new Persona(nombre));
	Persona pGorriti = model.getById(idNuevo);
	assertEquals(nombre, pGorriti.getNombre());

	assertNull(model.getById(13));

    }

    @Test
    public void testInsert() throws Exception {

	int todos = model.getAll().size();

	int idNuevaPersona = model.insert(new Persona("El nuevo"));
	assertTrue(Persona.ID_NULL < idNuevaPersona);
	assertEquals("No se ha generado bien el ID", todos, idNuevaPersona);

	assertEquals("No deberia insertarse", Persona.ID_NULL,
		model.insert(null));

	assertEquals("debemos tener un registro nuevo ", todos + 1, model
		.getAll().size());

	// insertar cuando no existen registros
	ModeloPersona.truncateTable();
	int idNuevaPersona2 = model.insert(new Persona("El nuevo2"));
	assertTrue("Debe poder insertar a pesar de no haber registros",
		Persona.ID_NULL < idNuevaPersona2);

    }

    @Test
    public void testDelete() throws Exception {

	// comprobar eliminar 1 persona
	int todos = model.getAll().size();

	assertTrue(model.delete(1));
	// comprobar que este borrado
	assertNull(model.getById(1));

	assertFalse(model.delete(13));
	assertNull(model.getById(13));

	assertEquals("debemos tener un registro menos ", todos - 1, model
		.getAll().size());

    }

    @Test
    public void testDeleteAll() throws Exception {
	// eliminar todas las personas
	Persona p = null;
	ArrayList<Persona> personas = model.getAll();
	for (Persona persona : personas) {
	    assertTrue(model.delete(persona.getId()));
	}
	assertNull(model.getAll());
    }

    @Test
    public void testUpdate() throws Exception {

    }

}
