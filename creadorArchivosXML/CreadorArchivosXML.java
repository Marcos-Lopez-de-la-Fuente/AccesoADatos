package creadorArchivosXML;

import java.io.*;

import javax.xml.crypto.dsig.Transform;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;


import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class CreadorArchivosXML {

    public static final String rutaFitxer = "archivo.xml";

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            document.setXmlVersion("1.1");

            Element root = document.createElement("institut");
            document.appendChild(root);


            Element empleat = document.createElement("empleat");
            root.appendChild(empleat);


            Attr att_idEmpleat = document.createAttribute("id");
            att_idEmpleat.setValue("1");
            empleat.setAttributeNode(att_idEmpleat);

            // ! Otra forma de añadir un atributo en 1 sola línea
            empleat.setAttribute("idd", "2");


            Element nom = document.createElement("nom");
            nom.appendChild(document.createTextNode("Joan"));
            empleat.appendChild(nom);


            Element llinatge1 = document.createElement("llinatge1");
            llinatge1.appendChild(document.createTextNode("Moragues"));
            empleat.appendChild(llinatge1);


            Element llinatge2 = document.createElement("llinatge2");
            llinatge2.appendChild(document.createTextNode("Mas"));
            empleat.appendChild(llinatge2);


            Element telefon = document.createElement("telefon");
            telefon.appendChild(document.createTextNode("123456789"));
            empleat.appendChild(telefon);







            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            // transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "1");



            DOMSource domOrigen = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(CreadorArchivosXML.rutaFitxer));




            transformer.transform(domOrigen, streamResult);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
