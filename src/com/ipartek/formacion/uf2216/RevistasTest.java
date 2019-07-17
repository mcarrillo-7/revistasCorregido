package com.ipartek.formacion.uf2216;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RevistasTest {

	Revistas revista;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		revista = new Revistas();
	}

	@AfterEach
	void tearDown() throws Exception {
		revista = null;
	}





	

	@Test
	void testSetTitle() throws Exception {
		
		revista.setTitle("Buenosdias");
		assertEquals("Buenosdias", revista.getTitle());
		
		try {
			revista.setTitle("bu");
			fail("Titulo demasiado corto");

		} catch (Exception e) {
			assertTrue(true);
		}
		
		
		
		
	}



	@Test
	void testSetIsbn() throws Exception {
		
		revista.setIsbn("0987654321");
		assertEquals("0987654321", revista.getIsbn());
		
		
		try {
			revista.setIsbn("098765432");
			fail("No llega a los 10 caracteres permitidos");
		} catch (Exception e) {
			assertTrue(true);
		}
		
		
		try {
			revista.setIsbn("09876543210");
			fail("Supera los 10 caracteres permitidos");
		} catch (Exception e) {
			assertTrue(true);
		}
		
		
	}



	@Test
	void testSetPages() throws Exception{
		
		revista.setPages(1);
		assertEquals(1, revista.getPages());

		try {
			revista.setPages(0);
			fail("Minimo una página");
		} catch (Exception e) {
			assertTrue(true);
		}
		
		try {
			revista.setPages(-5);
			fail("No puede tener menos de 1 página");
		} catch (Exception e) {
			assertTrue(true);
		}

	}
}

/*
	@Test
	void testSetisDigital() throws Exception {
		
		revista.setisDigital('d');
		assertTrue(revista.isDigital());

		revista.setisDigital('p');
		assertFalse(revista.isDigital());

		try {
			revista.setisDigital('b');
			fail("Formato no válido");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
*/
