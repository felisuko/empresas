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
}
