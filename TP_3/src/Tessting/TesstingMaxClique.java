package Tessting;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import businessCode.Grafo;
import businessCode.MaxClique;
import businessCode.Vertice;


public class TesstingMaxClique  {
	
	
	@Ignore
	public static void main(String[] arg) {
		ArrayList<Vertice> aux = new ArrayList<Vertice> ();
		aux.addAll( MaxClique.solver(getGrafo()) );
		for(Vertice i : aux){
			System.out.println("vertice = " + i.getNumero() + " peso: " + i.getPeso());
		}
	}
	
	@Test 
	public final void verdad() {
		assertTrue(2 == 2);
	}
	
	@Test 
	public final void solverTest() {
		
		ArrayList<Vertice> esperados = new ArrayList<Vertice>();
		esperados.add( new Vertice(5, 5.0));
		esperados.add( new Vertice(4, 6.0));
		esperados.add( new Vertice(3, 10.0));
		
				
		ArrayList<Vertice> aux = new ArrayList<Vertice> ();
		aux.addAll( MaxClique.solver(getGrafo()) );
		
//		for(Vertice i : aux){
//			System.out.println("vertice = " + i.getNumero() + " peso: " + i.getPeso());
//		}
		
		assertTrue(mismaCollecion(aux, esperados) == true);
	}
	
	
	@Test 
	public final void solverTest2() { // en este caso la Clique de peso maximo deberia ser un vertice aislado
		
		ArrayList<Vertice> esperados = new ArrayList<Vertice>();
		esperados.add( new Vertice(0, 20.0));
		
		
				
		ArrayList<Vertice> aux = new ArrayList<Vertice> ();
		aux.addAll( MaxClique.solver(getGrafo2()) );
//		System.out.println("segunda tanda");
//		for(Vertice i : aux){
//			System.out.println("vertice = " + i.getNumero() + " peso: " + i.getPeso());
//		}
		
		assertTrue(
				mismaCollecion(aux, esperados) == true);
	}
	
	
    private final static boolean mismaCollecion(ArrayList<Vertice> conj, ArrayList<Vertice> otro ) {
		
		if(conj.size() != otro.size()) {
			return false;
		}
		
		for(Vertice i : conj) {
			if(otro.contains(i) == false) {
				return false;
			}
				
		}
		
		return elementosRepetidos(conj) == elementosRepetidos(conj) == true;
	}
	
	
	private static boolean elementosRepetidos(ArrayList<Vertice> conj) {
		
		int aux = 0;
		for(Vertice i: conj){
			aux = 0;
			for(Vertice j: conj) {
				if(i.getNumero() == j.getNumero()) {
					aux++;
				}
			}
			if(aux > 1) {
				return false;
			}
		}
		return true;
	}
	
	private static Grafo getGrafo() {
		Grafo g = new Grafo(6);
		g.agregarArista(0, 1);
		g.agregarArista(0, 4);
		g.agregarArista(0, 5);
		g.agregarArista(1, 5);
		g.agregarArista(1, 2);
		g.agregarArista(2, 3);
		g.agregarArista(2, 5);
		g.agregarArista(3, 5);
		g.agregarArista(3, 4);
		g.agregarArista(4, 5);
		
		
		g.setearPeso(0, 5.0);
		g.setearPeso(1, 5.0);
		g.setearPeso(2, 5.0);
		g.setearPeso(4, 6.0);
		g.setearPeso(5, 5.0);
		g.setearPeso(3, 10.0);
		
		return g;
		
	}
	
	
	// este cuenta con sum clique de peso maximo formada por unicamente el vertice 0
	private static Grafo getGrafo2() {
		Grafo g = new Grafo(5);
		for(int i=1; i<g.tamanio(); i++) {
			for(int j=2; j<g.tamanio(); j++) {
				if(i != j) {
					g.agregarArista(i, j);
				}
			}
		}
	
		
		
		g.setearPeso(0, 20.0); // vertice aislado, y clique maxima
		g.setearPeso(1, 3.0);
		g.setearPeso(2, 3.0);
		g.setearPeso(3, 3.0);
		g.setearPeso(4, 5.0);
		
		
		return g;
		
	}
	
	

	

}
