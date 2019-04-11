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
    
	
}