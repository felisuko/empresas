package _MISPRUEBAS;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Utils {

    private final static String FORMATO_IMPORTE = "###,###.##";
    private final static String FORMATO_DDMMYYYY = "dd/mm/yyyy";
	
    /**
     * FGC. Transforma String to TimeStamp. Sin formato 
     * @param strFecha
     * @return
     */
    public static Timestamp stringToTimestamp(String strFecha)  throws Exception {
    	return (stringToTimesTamp(strFecha, null)); 
    }

    /**
     * FGC. Transforma un Objeto de tipo String to TimeStamp 
     * 
     * @param strFecha
     * @return
     * @throws Exception
     */
    public static Timestamp stringToTimestamp(Object strFecha)  throws Exception {
    	return (strFecha instanceof String? stringToTimesTamp ( ((String)strFecha) , null) : null); 
    }
    
    /***
     * FGC. Transforma String to TimeStamp. Con formato
     * 
     * @param strFecha
     * @param strFormato
     * @return
     */
    public static Timestamp stringToTimesTamp(String strFecha, String strFormato) {
    	Timestamp timestamp = null; 
    	SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dateFormat = (isNullOrEmpty(strFormato)? formatoFecha : new SimpleDateFormat(strFormato));
        try{
            if (isNoneEmpty(strFecha)){
            	Date dFecha = dateFormat.parse(strFecha);
            	timestamp = new Timestamp(dFecha.getTime());
            }
        }catch(Exception e){
        	//Log.error("UtilFechas. stringToTimestamp() {"+e.toString()+"}");
        }
        return timestamp;
	}

    /**
     * FGC. Transforma TimeStamp a String. Sin formato (formato defecto DD/MM/YYYY) 
     * @param tsFecha
     * @return
     */
    public static String timestampToString(Timestamp tsFecha) {
    	return (timestampToString(tsFecha, FORMATO_DDMMYYYY));
    }
    
    /**
     * FGC.  Transforma (OBJECT)TimeStamp a String. Sin formato (formato defecto DD/MM/YYYY)
     * @param tsFecha
     * @return
     */
    public static String timestampToString(Object tsFecha) {
    	return (timestampToString(((Timestamp)tsFecha), FORMATO_DDMMYYYY));
    }

    /**
     * FGC. Transforma TimeStamp s String. Con formato 
     * @param tsFecha
     * @param strFormato
     * @return
     */
    public static String timestampToString(Timestamp tsFecha, String strFormato) {
    	String strFecha = "";
    	try{
			SimpleDateFormat sdf = null;
        	if (isNoneEmpty(strFormato) && tsFecha!=null){
				sdf = new SimpleDateFormat(strFormato);
        		strFecha  = sdf.format(new Date(tsFecha.getTime()));
           	}
        }catch(Exception e){
        	// Log.error("timestampToString() {"+e.toString()+"}");
        }
    	return  strFecha;
    }
    
    /**
     * FGC. Genera lista ArrayList<Object> 
     * @param tamanio
     * @return
     */
    public static ArrayList<Object> inicializArrayListOject (int tamanio){
    	ArrayList<Object> lstArrayObject = new ArrayList<Object>(0);
        for (int i = 0; i < tamanio; i++) { lstArrayObject.add("");}
        return lstArrayObject;
    }
    
    /**
     * FGC. Genera lista List<String>
     * @param tamanio
     * @return
     */
    public static List<String> inicializaListaArrayString (int tamanio){
        List<String> lstArrayString = new ArrayList<String>(0);
        for (int i = 0; i < tamanio; i++) { lstArrayString.add("");}
        return lstArrayString;
    }
    
    /**
     * FGC. Genera lista List<Object>
     * @param tamanio
     * @return
     */
    public static List<Object> inicializaListaArrayObject (int tamanio){
        List<Object> lstArrayString = new ArrayList<Object>(0);
        for (int i = 0; i < tamanio; i++) { lstArrayString.add("");}
        return lstArrayString;
    }    

    /**
     * FGC. String a long 
     * @param valor
     * @return
     */
    public static Long stringToLong (String valor){
  	  Long lValor = null;
  	  if (isNoneEmpty((String) valor)) {
  		  try{ lValor = Long.parseLong(valor.trim());
  		  }catch (Exception e){
  			lValor = null;
  		  }
  	  }
  	  return lValor;
    }

    /**
     * FGC
     * @param dato
     * @return
     */
    public static String getValue (String dato){
    	return (isNullOrEmpty(dato)? "" : dato); 
    }
    
    /**
     * FGC. Devuelve valor Long, valida el tipo de dato de entrada, String o Long 
     * @param valor
     * @return
     */
    public static Long getValueLong (Object valor){
    	Long retorno = null; 
    	if (valor instanceof String){
    		retorno  = stringToLong((String)valor);
    	}else
    	if (valor instanceof Long){
    		retorno  = (Long)valor;
    	}
        if (valor instanceof BigDecimal){
        	retorno  = bigDecimalToLog ((BigDecimal)valor);
        }   
    	return retorno;
    }
    
    /**
     * FGC. Devuelve valor String, valida el tipo de dato de entrada, String, Long, BigDecimal
     * @param valor
     * @return
     */
    public static String getValueString (Object valor){
    	String retorno = null; 
    	if (valor instanceof String){
    		retorno  = getValue((String)valor);
    	}else
    	if (valor instanceof Long){
    		retorno  = longToString ((Long)valor);
    	}else
        if (valor instanceof BigDecimal){
        	retorno  = bigDecimalToString ((BigDecimal)valor);
    	}else
        if (valor instanceof Integer){
        	retorno  = integerToString ((Integer)valor);
        }
    	return retorno;
    }   
	
    /**
     * FGC. Devuelve valor Long. Si es nulo su valor, devuelve el valor por defecto 
     * @param valor
     * @return
     */
    public static Long getValueLong (Object valor, Long valorDefecto){
    	Long lRespuesta = getValueLong (valor);
    	return (lRespuesta==null? valorDefecto : lRespuesta);
    }
	
    /**
     * FGC. Devuelve valor String, valida el tipo de dato de entrada, String, Long, BigDecimal
     * @param valor
     * @return
     */
    public static Long getValueLong (Object valor){
    	Long retorno = 0L; 
    	if (valor instanceof String){
    		retorno  = stringToLong((String)valor);
    	}else
    	if (valor instanceof Long){
    		retorno  = (valor != null? (Long)valor : 0L);
    	}else
        if (valor instanceof BigDecimal){
        	retorno  = bigDecimalToLong ((BigDecimal)valor);
    	}else
        if (valor instanceof Integer){
        	retorno  = integerToLong ((Integer)valor);
        }
    	return retorno;
    }  
 
    /**
     * @param valor
     * @return
     */
    public static Long stringToLong (String valor){
    	Long lValor = null;
    	if (isNoneEmpty((String) valor)) {
    		try{ 					lValor = Long.parseLong(valor.trim()); }
    		catch (Exception e){	lValor = null; }
    	}
    	return lValor;
    }
    
    /**
     * @param valor
     * @return
     */
    public static Long bigDecimalToLong (BigDecimal valor){
    	Long lValor = null;
    	if (valor!=null) {
    		try{ 					lValor = valor.longValue() ; }
    		catch (Exception e){	lValor = null; }
    	}
    	return lValor;
    }    
    
    /**
     * @param valor
     * @return
     */
    public static Long integerToLong (Integer valor){
    	Long lValor = null;
    	if (valor!=null) {
    		try{ 					lValor = valor.longValue()  ; }
    		catch (Exception e){	lValor = null; }
    	}
    	return lValor;
    }      
	
    /**
     * FGC. Devuelve valor Long
     * 
     * @return
     */	
    public static Long obtenerLong(Object o) {
        Long retorno = null;
	try {
	    if (o != null) {
	        if (o instanceof BigDecimal) {
	            retorno = Long.valueOf(((BigDecimal)o).toString());
                }else if (o instanceof Long) {
	            retorno = (Long)o;
                }else if (o instanceof Integer) {
	            retorno = ((Integer)o).longValue();
	        }else {
	            retorno = Long.valueOf(o.toString().trim());
	        }
            }
        }
        catch (NumberFormatException e) {
	    retorno = null;
	}
        return retorno;
    }
	
    
    /**
     * FGC. Devuelve valor String, si el dato es nulo devuelve el valor por defecto pasado. 
     * 
     * @param objValor
     * @param valorDefecto
     * @return
     */
    public static String getValueString (Object objValor, String valorDefecto){
    	String strValor = getValueString (objValor);
    	return (strValor == null? valorDefecto : strValor);
    }
        
	/**
	 * FGC.  Convierte LongToString
	 * @param valor
	 * @return
	 */
    public static String longToString (Long valor){
      return (valor != null? Long.toString(valor) : "");
	}
    
	/**
	 * FGC.  Convierte bigDecimalToString
	 * @param valor
	 * @return
	 */
    public static String bigDecimalToString (BigDecimal valor){
      return (valor != null? valor.toString() : "");
	}

	/**
	 * FGC.  Convierte integerToString
	 * @param valor
	 * @return
	 */
    public static String integerToString (Integer valor){
      return (valor != null? valor.toString() : null);
	}    
    	
	/**
	 * FGC.  Convierte bigDecimalToString
	 * @param valor
	 * @return
	 */
    public static Long bigDecimalToLog (BigDecimal valor){
      return (valor != null? valor.longValue() : null);
	}


	/**
	 * FGC. Convierte LongToString, con valor por defecto si llega vacio
	 * @param valor
	 * @return
	 */
    public static String longToString (Long valor, String valorDefecto){
        return (valor != null? Long.toString(valor) : valorDefecto);
    }

	/**
	 * FGC.  Comprueba si un Object de String está relleno, o si es un Object si está inicialidado. 
	 * @param valor
	 * @return
	 */    
    public static boolean isCampoRelleno(Object value){
	return  (value instanceof String? (value != null && !"".equals(((String)value).trim())) : (value != null));
    }

	/**
	 * FGC.  Transforma a mayusculas si esta informada la cadena 
	 * @param valor
	 * @return
	 */      
    public static String toUpper(String cadena){
    	return ((isCampoRelleno(cadena))? cadena.toUpperCase() : cadena);
	}
    
    /**
     * Devuelve true si la cadena de texto es null o es vacia
     * @param str : Sring a comprobar.
     * @return booleano indicando que la cadena de texto es nula o vacía
     */
    public static boolean isNullOrEmpty(String str) {
        return (str == null || "".equals(str.trim()));
    }

    /**
     * Chequea si el valor no es nulo, ni vacio
     * @param str
     * @return
     */
    public static boolean isNoneEmpty(String str) {
        return (!isNullOrEmpty(str));
    }
    
    /**
     * FGC.  Reemplaza salto de linea por cadena '\n'
     * @param valor
     * @return
     */ 
    public static String eliminarSaltoLinea(String valor) {
	return eliminarSaltoLinea(valor, "\\\\n"); 
    }    
    
    /**
     * FGC.  Reemplaza salto de linea por la cadena recibida por parametro
     * @param valor
     * @param valorReemplazo
     * @return
     */
    public static String eliminarSaltoLinea(String valor, String valorReemplazo) {
    	return getValue(valor).replaceAll("\n", valorReemplazo);
    }    	

    /**
     * Reemplaza barra invertida por barra normal
     *
     * @param prueba
     * @return
     */
    public static String reemplazaSlash_x_Backslash (String valor){
    	return getValue(valor).replaceAll("\\\\","/");
    }
    
    /**
     * 
     * @param valor
     * @return
     */
    public static String escaparBarraInvertida (String valor){
    	return  getValue(valor).replaceAll("\\\\","\\\\\\\\");
    }

	/**
	 * 
	 * @param valor
	 * @return
	 */
    public static String formatImporte (String valor){
		return formatImporte (valor, FORMATO_IMPORTE);
    }
	
	/**
	 * 
	 * @param valor
	 * @param strFormatoImporte
	 * @return
	 */
    public static String formatImporte (String valor, String strFormatoImporte){
    	DecimalFormat formateador = new DecimalFormat("###,###.##");
    	Double dValor = stringToDouble(valor, 0D);
    	return  formateador.format(dValor);
    }


    /**
    * Devuleve el simbolo del euro. Se realiza este juego para no tener problema con los Encodig
    * @return
    */
    private String getMonedaEuro (){
	// "80", simbolo del euro en Hexadecimal. transforma el codigo hexadecial a decimal
        return (""+((char)Integer.parseInt("80",16)));
    }
	
    /**
    * Limpia texto, eliminando caracteres que no sean ni numeros ni letras
    * @param entreada
    * @return
    */	
    private static String limpiarTexto (String entreada){
        return (entreada.replaceAll("[^a-zA-Z0-9]", "")); 
    }

    /**
     * FGC.  Convierte stringToDouble
     * @param valor
     * @return
     */
     public static Double stringToDouble (String valor){
      	  Double dValor = null;
      	  if (isNoneEmpty((String) valor)) {
      		  try{ dValor = Double.parseDouble(valor.trim());
      		  }catch (Exception e){
      			dValor = null;
      		  }
      	  }
      	  return dValor;
     }

    /**
    * FGC.  Convierte doubleToString
    * @param valor
    * @return
    */
    public static String doubleToString (Double valor){
        return (valor != null? Double.toString(valor) : "");
    }
      
    /**
     *  Los NIE's de extranjeros residentes en España tienen una letra (X, Y, Z), 7 números y dígito de control.
     *  Para el cálculo del dígito de control se sustituye:
     *  X -> 0	
     *  Y -> 1
     *  Z -> 2
     *  y se aplica el mismo algoritmo que para el NIF.
     */
    private static boolean isValidNIE (String nie){
        String posicionUno="";
        if (nie.toUpperCase().startsWith("X") || nie.toUpperCase().startsWith("Y") || nie.toUpperCase().startsWith("Z")){
            posicionUno = (nie.toUpperCase().startsWith("X")? "0":nie.toUpperCase().startsWith("Y")? "1" : "2");
        }
        nie = posicionUno+nie.substring(1);

    	return (isValidDNI (nie));
    }
	
    /**
     * Validar DNI nov-2019
     * 
     * @param dni
     * @return
     */
    private static boolean isValidDNI(String dni) {
	boolean result = false;
	final Pattern pattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
	final Matcher matcher = pattern.matcher(dni);

	if (matcher.matches()) {
		final String letra = matcher.group(2);
		final String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
		int index = Integer.parseInt(matcher.group(1));
		index = index % PRIME_23;
		final String reference = letters.substring(index, index + 1);
		result = (reference.equalsIgnoreCase(letra)); 
	} 
	return result;
    }

	
}
