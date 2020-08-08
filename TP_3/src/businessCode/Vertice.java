package businessCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class Vertice {
	
	private int numero;
	private double peso;
	
//	es una lista de numeros y no de objetos Vertice, porque da problemas al serializar con Json,
//	porque se serializa cada vertice y sus vecinos de forma recursiva
	private ArrayList<Integer> vecinos;
	
	/**
	 * 
	 * @param int numero
	 * @param Double peso
	 */
	public Vertice(int numero, double peso) {
		
		this.numero = numero;
		this.peso = peso;
		this.vecinos = new ArrayList<Integer> ();
	}

	
	public void agregarVecino(int vecino) {
		
		vecinos.add(vecino);
	}
	
	public void quitarVecino(Vertice vecino) {
		
		for(Integer i: vecinos) {
			if(i == vecino.getNumero()) {
				this.vecinos.remove(i);
			}
		}
	}
	
	
	public boolean esVecino( Vertice vertice) {
		
		for(Integer i: vecinos) 
			if(i  == vertice.getNumero()) 
				return true;
		return false;
	}
	
	
	
	public String toString() {
		
		return "numero: " + this.numero + " peso: " + this.peso;
	}
	@Override
	public boolean equals(Object otro) {
		if(this.numero == ((Vertice) otro).getNumero())
			return true;
		return false;
	}
	
	
	
//	getters and setters
	
	public int getNumero() {
		return numero;
	}

	public double getPeso() {
		return peso;
	}

	
	public void setPeso(double peso) {
		this.peso = peso;
	}


	@SuppressWarnings("unchecked")
	public ArrayList<Integer> getVecinos() {
		
		return (ArrayList<Integer>) this.vecinos.clone();
	}
	
	

}
