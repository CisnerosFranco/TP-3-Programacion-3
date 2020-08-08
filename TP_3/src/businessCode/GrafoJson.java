package businessCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class GrafoJson {

	//JSON /GSON es una libreria que se usa para serializar Datos en bits y guardarlos en disco
	
	
	private Grafo grafo;
	
	
	/**
	 * Constructor
	 */
	public GrafoJson() {
		
		
	}
	
	public void setGrafo(Grafo g) {
		
		this.grafo = clonar(g);
	}
	
	public Grafo getGrafo() {
		
		return clonar(this.grafo);
	}
	
	private Grafo clonar(Grafo g) {
		
		Grafo ret = new Grafo(g.tamanio());
		for(int i=0; i<g.tamanio(); i++) {
			for(int j= 1; j<g.tamanio(); j++ ) {
				if(i!=j)
					if(g.existeArista(i, j)) {
					ret.agregarArista(i, j);
				}
			}
			
			ret.setearPeso(i, g.getPeso(i));
		}	
		return ret;
	}
	
	
	/**
	 * lo que se retorna es un archivo Json formato simple
	 * 
	 */
	public String generarJSON() {
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(this); //
		return json;
	}
	
	
	/**
	 * Se genera un archivo JSON formato Pretty (Lindo para la vista)
	 * facil de ver pero si se vulve largo cuesta mas que el formato simple
	 * 
	 */
	public String generarJSONPretty() {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); //Creamos un Json Preety
		String json = gson.toJson(this);
		return json;
	}
	
	
	public void guardarJSON(String JsonFile, String destinyFile) {
		
		try {
			FileWriter writer = new FileWriter(destinyFile);
			writer.write(JsonFile);
			writer.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * retorna un objeto PeopleJSON, para acceder al contenido a este hay
	 * pedirle que te genere un Jason ó un JasonPretty
	 * 
	 */
	public static  GrafoJson leerJSON( String file) {
		
		Gson gson = new Gson();
		GrafoJson ret = null;
		try {	
			BufferedReader br = new BufferedReader(new FileReader(file));
			ret = gson.fromJson(br, GrafoJson.class);	
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return ret;
	}

}
