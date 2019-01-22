package _MISPRUEBAS;

import java.nio.charset.StandardCharsets;

import javax.xml.bind.*;

public class Farmacia {

	public static void main(String[] args) {

		String idVeriUser		= "servidorsanitas";
		String idUserName		= "IDPRUEBA";
		String idServices		= "PAGINAMEDICAMENTOSPRUEBAS";
		
		/* Genera decode BASE 64
		 */
		String idVeriUserSemilla 	= decodeBase64(idVeriUser);
		
		/* Genera decode
		 */
		String idServicesCifrado =  cifrado(idServices, idVeriUserSemilla);
		String idUserNameCifrado =  cifrado(idUserName, idVeriUserSemilla); 
		
		System.out.println("idUserNameCifrado ["+idUserNameCifrado+"] - [2EzOL1r1] IDPRUEBA");
		System.out.println("idServicesCifrado ["+idServicesCifrado+"] - [4QnD-9yZ9nm3l3KFXfaV1lIHB] PAGINAMEDICAMENTOSPRUEBAS");
	}

	/**
	 * Devuelve el texto en BASE 64
	 * @param texto
	 * @return
	 */
	private static String decodeBase64 (String texto){
		byte[] message = texto.getBytes(StandardCharsets.UTF_8);
		String encoded = DatatypeConverter.printBase64Binary(message);
		return encoded;	
	}
		
	/**
	 * 
	 * @param texto
	 * @param clave
	 * @return
	 */
	private static String cifrado (String texto, String clave){ 
		// Tabla de cifrado 
		String tablaCifrado = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789-_";
		
		// Hacemos la clave de una longitud mayor o igual al texto a cifrar 
		while (clave.length() < texto.length()){
			clave = clave + clave;	
		}
		
		//Creamos los arrays necesarios 
		int[] listaTexto = new int[texto.length()];  
		int[] listaClave = new int[texto.length()];  
		int[] listaCoded = new int[texto.length()]; 
		String coded 	 = "";

		for (int i = 0; i < texto.length(); i++) { 
			listaTexto[i] = tablaCifrado.indexOf(texto.charAt(i)); 
			listaClave[i] = tablaCifrado.indexOf(clave.charAt(i));
			listaCoded[i] = mod ((listaTexto[i] + listaClave[i]), 64 );
			coded+= tablaCifrado.charAt( listaCoded[i] );
		}
		return coded; 
	} 
		
	/**
	 * 
	 * @param x
	 * @param m
	 * @return
	 */
	private static int mod(int x, int m){
		return (x % m + m) % m; 
	}


	
}
