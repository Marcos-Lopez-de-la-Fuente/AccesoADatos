package leerArchivosXML;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class leerArchivos {
    private static final String rutaFitxer = "C:\\Users\\monoq\\Desktop\\Workspace\\DAM\\DAM2\\AccesoADatos\\interactuarArchivosXML\\leerArchivosXML\\archivo.xml";
    public static void main(String[] args) {
        try {
            
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            LaOtraClaseParaLeer laOtraClaseParaLeer = new LaOtraClaseParaLeer();
            saxParser.parse(rutaFitxer, laOtraClaseParaLeer);





        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
