
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

    public static final String rutaFitxer = "Marcos.xml";

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
            // transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "1");



            DOMSource domOrigen = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(CreadorArchivosXML.rutaFitxer));




            transformer.transform(domOrigen, streamResult);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
