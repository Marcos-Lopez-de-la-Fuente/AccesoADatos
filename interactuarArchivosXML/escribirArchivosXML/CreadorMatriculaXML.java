package escribirArchivosXML;

import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;


import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class CreadorMatriculaXML {

    public static final String rutaFitxer = "./interactuarArchivosXML/escribirArchivosXML/matricula.xml";

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            document.setXmlVersion("1.1");
            document.setXmlStandalone(false);

            Element root = document.createElement("cicle");
            root.setAttribute("codi", "IFC32");
            root.setAttribute("tipus", "CFGS");
            root.setAttribute("sigles", "DAM");
            root.setAttribute("codi", "IFC32");
            root.setAttribute("nom", "Desenvolupament aplicacions multiplataforma");
            document.appendChild(root);



            Element element2 = document.createElement("modul");
            element2.setAttribute("curs", "1");
            element2.setAttribute("codi", "0483");
            root.appendChild(element2);

            Element element21 = document.createElement("nom");
            element21.appendChild(document.createTextNode("Sistemas informáticos"));
            element2.appendChild(element21);
            Element element22 = document.createElement("nombreHores");
            element22.appendChild(document.createTextNode("170"));
            element2.appendChild(element22);


            Element element3 = document.createElement("modul");
            element3.setAttribute("curs", "1");
            element3.setAttribute("codi", "0484");
            root.appendChild(element3);

            Element element31 = document.createElement("nom");
            element31.appendChild(document.createTextNode("Bases de Datos"));
            element3.appendChild(element31);
            Element element32 = document.createElement("nombreHores");
            element32.appendChild(document.createTextNode("170"));
            element3.appendChild(element32);


            Element element4 = document.createElement("modul");
            element4.setAttribute("curs", "1");
            element4.setAttribute("codi", "0485");
            root.appendChild(element4);

            Element element41 = document.createElement("nom");
            element41.appendChild(document.createTextNode("Programación"));
            element4.appendChild(element41);
            Element element42 = document.createElement("nombreHores");
            element42.appendChild(document.createTextNode("230"));
            element4.appendChild(element42);




            Element element1 = document.createElement("modul");
            element1.setAttribute("curs", "2");
            element1.setAttribute("codi", "0486");
            root.appendChild(element1);

            Element element11 = document.createElement("nom");
            element11.appendChild(document.createTextNode("Accés a dades"));
            element1.appendChild(element11);
            Element element12 = document.createElement("nombreHores");
            element12.appendChild(document.createTextNode("125"));
            element1.appendChild(element12);




            







            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");



            DOMSource domOrigen = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(CreadorMatriculaXML.rutaFitxer));




            transformer.transform(domOrigen, streamResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
