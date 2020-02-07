package pruebas.libreria;


public class UtilString {

	/**
	 * 
	 * @param dato
	 * @param tamMax
	 * @return
	 */
	private static String maximoValor (String dato, int tamMax){
		return  (dato==null? "" : (dato.length()>tamMax? dato.substring(0, tamMax): dato));
	}


}
		
