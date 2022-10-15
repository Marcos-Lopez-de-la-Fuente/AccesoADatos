package leerArchivosXML;



import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

// La profe ha llamado a la clase "LlegirSAXFitxerXML_EventManager"
public class LaOtraClaseParaLeer extends DefaultHandler {

    public LaOtraClaseParaLeer() {}

    @Override
    public void startDocument() {}

    @Override
    public void startElement(String url, String nombreLocal, String nombreCualif, Attributes atributos) {
        System.out.print("<" + nombreCualif + "");
        for (int i = 0; i < atributos.getLength(); i++) {
            System.out.print(" " + atributos.getLocalName(i) + "=" + atributos.getValue(i));
        }
        System.out.println(">");
    }

    @Override
    public void endElement(String url, String nombreLocal, String nombreCualif) {
        System.out.println("\n</" + nombreCualif + ">");
    }

    @Override
    public void characters(char[] cars, int inicio, int longitud) {
        String texto = new String(cars, inicio, longitud);
        if (texto.trim().length() == 0) return;
            System.out.print(texto);
    }
    
}
