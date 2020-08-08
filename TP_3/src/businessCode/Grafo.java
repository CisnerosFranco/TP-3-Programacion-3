package businessCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Grafo {
	
	// Representamos el grafo por lista de vecinos
	private ArrayList<Vertice> Vertices; // (Vertice , Peso)
	

	
	public Grafo(int vertices) {
		
		Vertices = new ArrayList<Vertice> ();		
		for(int i = 0; i<vertices; i++ ) {
			Vertices.add(new Vertice(i, 0.0));
		}
	}
	
	
	
	
	// Agregado de aristas
	public void agregarArista(int i, int j ) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
	
		for(Vertice vertice: this.Vertices) {
			if(vertice.getNumero() == i) {
				vertice.agregarVecino(j);
			}
			if(vertice.getNumero() == j) {
				vertice.agregarVecino(i);
			}
		}	
	}
	
	
	
	
	
	// Eliminacion de aristas
	public void eliminarArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		for(Vertice vertice: this.Vertices) {
			if(vertice.getNumero() == i) {
				vertice.quitarVecino(getVertice(j));
			}
			
			if(vertice.getNumero() == j) {
				vertice.quitarVecino(getVertice(i));
			}
		}		
	}

	
	// Informa si existe la arista especificada
	public boolean existeArista(int i, int j) {
		
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		
		return getVertice(i).esVecino( getVertice(j) );
	}
	

	/** Cantidad de vertices
	 * 
	 **/
	public int tamanio() {
		
		return this.Vertices.size();
	}

	

	
	
	public ArrayList<Vertice> getVecinos(Vertice v){
		
		ArrayList<Vertice> ret = new ArrayList<Vertice> ();
		for(Integer i: v.getVecinos()) {
			ret.add(getVertice(i));
		}
		
		return ret;
	}
	
	
	/**
	 * Este Metodo recive un vertice (que debe existir en el grafo) y el peso
	 * que se le asignara al vertice
	 */
	public void setearPeso(int vertice, double Peso) {
		
		if(Peso < 0.0) {
			throw new RuntimeException(" los vertices no pueden tener Peso negativo, peso: " + Peso);
		}
		verificarVertice(vertice);
		
		for(Vertice i: this.Vertices) 
			if(i.getNumero() == vertice) {
				i.setPeso(Peso);
				return;
			}
	}
	
	
	
	public double getPeso(int vertice) {
		
		verificarVertice(vertice);
		for( Vertice i: this.Vertices) 
			if(i.getNumero() == vertice)
				return i.getPeso();
		
		return 0;
	}
		
	
	@SuppressWarnings("unchecked")
	public ArrayList<Vertice> getVertices(){
		
		return (ArrayList<Vertice>) this.Vertices.clone();
	}
	
	
	public String getAristas() {
		String ret ="Aristas: ";
		for(int i = 0; i<tamanio(); i++) {
			for(int j=i+1; j<tamanio(); j++) {
				if(existeArista(i,j)) {
					ret+="["+i+","+j+"] ";
				}
			}
		}
		return ret;
	}
	
	
	
	public String mostrarVertices() {

		return this.Vertices.toString();
	}
	
	

	private Vertice getVertice(int i) {
		
		verificarVertice(i);
		
		for(Vertice vertice: this.Vertices) 
			if(vertice.getNumero() == i) {
				return vertice;
			}
		return null;
	}
	
	
	// Verifica que sea un vertice valido
	private void verificarVertice(int i)
	{
		if( i < 0 )
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
		
		if( i >= this.Vertices.size() )
			throw new IllegalArgumentException("Los vertices deben estar entre 0 y |V|-1: " + i);
	}

	// Verifica que i y j sean distintos
	private void verificarDistintos(int i, int j)
	{
		if( i == j )
			throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
	}
	
}