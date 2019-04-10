
package empresas.utilidades;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;


public class GenerarDocumento {

  private String convertirAXml(Produccion bean, Class clase) {

      String retorno = "";

          try {
        JAXBContext jaxbContext;
        StringWriter sw = new StringWriter();
        jaxbContext = JAXBContext.newInstance(clase);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "windows-1252");
        marshaller.marshal(bean, sw);
        retorno = sw.toString();
      }
          catch (Exception e) {
        Log.error(":convertirAXml(): Error al intentar convertir a XML." + e);
              throw new DatoInvalidoException("Error al intentar convertir a XML");
      }

      return retorno;
    }
  }
