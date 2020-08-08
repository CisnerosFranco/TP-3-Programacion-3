package Tessting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businessCode.Auxiliares;

public class AuxiliaresTest {

	
	@Test
	public final void testExisteGrafo() {
		assertTrue(Auxiliares.existeGrafo("Grafo.txt"));
	}
	@Test
	public final void testExisteGrafoFalse() {
		assertFalse(Auxiliares.existeGrafo("Graph.txt"));
	}

}
