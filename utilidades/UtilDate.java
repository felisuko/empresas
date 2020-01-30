package empresas.utilidades;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class UtilDate {

	
    /**
     * Si dia de PAP Miercoles y NO es un RSQ, no permite la subida retorno falso (no permite subida)
     *
     * @param retorno
     * @param nuevaFecha
     * @return
     */
    public static boolean esMiercoles(Timestamp nuevaFecha){

    	Calendar cal = Calendar.getInstance();
    	cal.setTime(new Date(nuevaFecha.getTime()));

    	return (Calendar.WEDNESDAY == cal.get(Calendar.DAY_OF_WEEK));
    }
    
    public static String horaActual() {
        return (new SimpleDateFormat("HH:mm:ss:SSSS", Locale.getDefault()).format(new Date()));
    }
	
    public static String fechaActual() {
        return (new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date()));
    }
	
	/**
	 *  FUNCIONES CADENAS TIEMPO
	 */
    private static String horaActual() {
        return (new SimpleDateFormat("HH:mm:ss:SSSS", Locale.getDefault()).format(new Date()));
    }

	/**
	 *  FUNCIONES CADENAS TIEMPO
	 */
    private static String horaActual() {
        return (new SimpleDateFormat("HH:mm:ss:SSSS", Locale.getDefault()).format(new Date()));
    }

    /*
     * ESTADISTICAS TIEMPO
     */
    public static void estadisticasTiempo (Date dInicio, Date dFin){
        double Duracion=(int) ((dFin.getTime()-dInicio.getTime())); // milisegundos
        double second		=  (Duracion/1000);
        double segundos		=  ((Duracion/1000)*100);
        double minutos 		=  ((Duracion/1000/60)*100);	//	100 paginas
        double horas		=  ((Duracion/1000/60)*100)/60; // 	100 paginas

        System.out.println("Time in miliseg (  1 pag): " + Duracion + " miliSegundos.");         		
        System.out.println("Time in seconds (  1 pag): " + second + " seconds.");
        System.out.println("Time in seconds	(100 pag): " + segundos + " seconds.");         
        System.out.println("Time in minutes (100 pag): " + minutos + " minutes.");
        System.out.println("Time in Hours   (100 pag): " + horas + " Hours.");
    }	
	
    /**
     * Fecha a futuro. Nov-2019
     * 
     * @param sfecha
     * @param formato
     * @return
     */	
    private static boolean esFechaHoraFuturo(String sfecha, String formato) {
    	boolean resultado=false;
    	try {
    		/**Obtenemos las fechas enviadas en el formato a comparar*/
    		SimpleDateFormat formateador = new SimpleDateFormat(isNullOrEmpty(formato)? "dd/MM/yyyy" : formato); 
    		Date dFecha		 = formateador.parse(sfecha);
    		Date fechaActual = new Date();
    	
    		resultado = (dFecha.after(fechaActual));
    	
    	} catch (ParseException e) {
    		System.out.println("Se Produjo un Error!!!  "+e.getMessage());
    	}
    	
    	return resultado;
    }    	
	
    /**
    * Eliminar hora de objeto Date 
    * @param date
    * @return
    */
    public static Date removeTime(Date date) {
      	Calendar cal = Calendar.getInstance();
      	cal.setTime(date);
      	cal.set(Calendar.HOUR_OF_DAY, 0);
      	cal.set(Calendar.MINUTE, 0);
      	cal.set(Calendar.SECOND, 0);
      	cal.set(Calendar.MILLISECOND, 0);
      	return cal.getTime();
    }      

    /**
    * fecha a futuro (sin hora)
    * @param dFecha
    * @return
    */
    private static boolean esFechaFuturo(Date dFecha) {
      	boolean resultado=false;
      	try {
      		Date fechaActual = removeTime(new Date());
      		dFecha = removeTime(dFecha);
      		resultado = (dFecha.after(fechaActual));
      	} catch (Exception e) {
      		System.out.println("Se Produjo un Error!!!  "+e.getMessage());
      	}
      	
      	return resultado;
    }        
	
      /**
       * 
       * @param sFecha
       * @param formato
       * @return
       */
      public static Date stringToDate (String sFecha, String formato){
    	  
    	  SimpleDateFormat sdf = new SimpleDateFormat ("".equals(formato)? "dd/mm/yyyy" : formato);
    	  Date fecha = new Date();
    	  try{
    		  fecha = sdf.parse(sFecha);  
    	  }catch(Exception e){
    		  System.out.println("stringToDate " + e);
    	  }
    	  
    	  return fecha; 
      }
	
	/**
	 * devuelve negativo si la fecha anterior es posterior a fecha actual
	 */
	private static int diferenciaDiasFechas (Date fechaActual, Date fechaAnterior){
		int dias=0;
		if (fechaActual !=null && fechaAnterior!=null){
			dias=(int) ((fechaActual.getTime()-fechaAnterior.getTime())/86400000);	
		}
	    return dias;
	}
	
	private static Date stringToDate (String sFecha, String formato){
		Date fecha = new Date();
		try{
			SimpleDateFormat dateformat3 = new SimpleDateFormat(formato) ;// "dd/MM/yyyy");
			fecha  = dateformat3.parse(sFecha);
		}catch(Exception e){ }
		return fecha;
	}
	
	
	
}
