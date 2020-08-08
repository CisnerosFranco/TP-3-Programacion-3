package businessCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Auxiliares {
	
	
	/**
	 * Te dice si existe el Grafo buscado
	 * 
	 */
	@SuppressWarnings("resource")
	public static boolean existeGrafo(String path) {
		
		try {	
			new FileReader(path);
		}
		catch(IOException e){
			return false;
		}
		return true;
	}

}
