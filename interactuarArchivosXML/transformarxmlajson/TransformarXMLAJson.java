package transformarxmlajson;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.*; // Librería importada localmente

public class TransformarXMLAJson {

    public static final String PATHFILEXML = "./interactuarArchivosXML/escribirArchivosXML/matricula.xml";
    private static final String PATHFILEJSON = "./interactuararchivosxml/transformarxmlajson/matricula.json";
    public static final int IDENTACION = 4;

    public static void main(String[] args) {

        try {
            // Leer archivo xml y convertirlo en String
            String strfitxerXML = new String(Files.readAllBytes(Paths.get(TransformarXMLAJson.PATHFILEXML)));

            // Convertir stringxml en objeto json (Importar localmente la librería org.json)
            JSONObject jsonObject = XML.toJSONObject(strfitxerXML);

            // Convertir objeto Json en String
            String strJson = jsonObject.toString(TransformarXMLAJson.IDENTACION);

            // Escribir el string "strJson" en el archivo "PATHFILEJSON"
            Files.write(Paths.get(TransformarXMLAJson.PATHFILEJSON), strJson.getBytes());


            System.out.println(new String(Files.readAllBytes(Paths.get(TransformarXMLAJson.PATHFILEJSON))));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
