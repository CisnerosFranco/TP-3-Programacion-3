package businessCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxClique {


		
	
	
	
	public static ArrayList<Vertice> solver(Grafo grafo) {
		
		ArrayList<Vertice> aux = ordenarPorMayorPeso(grafo.getVertices());
		
		ArrayList<Vertice> Clique = new ArrayList<Vertice> ();
		Clique.add(aux.get(0));
		
		ArrayList<Vertice> vecinos = new ArrayList<Vertice>();
		vecinos.addAll(grafo.getVecinos(Clique.get(0)));
		
		while(vecinos.size() > 0) {
			Clique.add(vecinoDeMayorPeso(vecinos));
			vecinos = VecinosEnComun(grafo, Clique);
		}
		return Clique;		
	}

	
	private static ArrayList<Vertice> VecinosEnComun(Grafo grafo, ArrayList<Vertice> conjunto) {
		
		ArrayList<Vertice> ret = new ArrayList<Vertice> ();
		Set<Vertice> vecindad = getVecindad(grafo, conjunto);
		
		for(Vertice i: vecindad) {
			if(vecinoDelConjunto(conjunto, i)) {
				ret.add(i);
			}
		}
		return ret;
	}
	
	
    private static boolean vecinoDelConjunto(ArrayList<Vertice> conjunto, Vertice candidato ) {
		
		for(Vertice i: conjunto) {			
			if(!i.esVecino(candidato))
				return false;
		}
		return true;
	}

    
	private static Set<Vertice> getVecindad(Grafo grafo, ArrayList<Vertice> conjunto) {
		
		Set<Vertice> ret = new HashSet<Vertice>();
		for(Vertice i: conjunto) {
			ret.addAll(grafo.getVecinos(i));
		}
		
		return ret;
	}

	
	private static Vertice vecinoDeMayorPeso(ArrayList<Vertice> vecinos) {

		return ordenarPorMayorPeso(vecinos).get(0);
	}
	
		
	/**
	 * Ordena los elementos del Conjunto de vertices
	 */
	private static ArrayList<Vertice>  ordenarPorMayorPeso(ArrayList<Vertice> conjunto){
		
		ArrayList<Vertice> ret = conjunto;
		
		Collections.sort(ret, new Comparator<Vertice>() {

			@Override
			public int compare(Vertice uno, Vertice otro) {
					
				if(uno.getPeso() > otro.getPeso())
					return -1;
				else if(uno.getPeso() < otro.getPeso())
					return 1;
				else
					return 0;
			}
		});
		
		return ret;
	}
	
}



