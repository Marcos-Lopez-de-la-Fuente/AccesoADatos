package interactuararchivosjson.leerarchivosjson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.*; // Librería importada localmente

public class LeerArchivosJson {
    JSONObject jsonObject;
    JSONArray jsonArray;

    private static final String PATHFILEJSON = "C:\\Users\\marco\\Desktop\\Workspace\\DAM\\DAM2\\AccesoADatos\\interactuararchivosjson\\leerarchivosjson\\matricula.json";
    private static final String PATHFILEJSONVIOLETA = "C:\\Users\\marco\\Desktop\\Workspace\\DAM\\DAM2\\AccesoADatos\\interactuararchivosjson\\leerarchivosjson\\institutoPruebasVioleta.json";

    public static void main(String[] args) {
        try {
            // Crear un String del archivo Json
            String stringFileJSON = new String(Files.readAllBytes(Paths.get(LeerArchivosJson.PATHFILEJSON)));
            String stringFileJSONVioleta = new String(
                    Files.readAllBytes(Paths.get(LeerArchivosJson.PATHFILEJSONVIOLETA)));

            // Convertir el String en un objeto "JSONObject"
            JSONObject jsonObject = new JSONObject(stringFileJSON);
            JSONObject jsonObjectVioleta = new JSONObject(stringFileJSONVioleta);

            // ! institutoPruebasVioleta.json

            // El método keySet() devuelve un Array de las claves en el primer nivel del
            // Json
            System.out.println("Violeta --> keySet(): " + jsonObjectVioleta.keySet());

            // El método length() devuelve el número de claves en el primer nivel del Json
            System.out.println("Violeta --> length(): " + jsonObjectVioleta.length());

            // Método getString() devuelve el valor de la "key" que le introduzcas
            System.out.println("Violeta --> getString(): " + jsonObjectVioleta.getString("institut"));

            // Método getJSONArray() devuelve un Array del valor de la "key" que le
            // introduzcas
            JSONArray jsonArrayVioleta = jsonObjectVioleta.getJSONArray("empleats");
            System.out.println("Violeta --> getJSONArray(): " + jsonArrayVioleta);



            for (int i = 0; i < jsonArrayVioleta.length(); i++) {
                System.out.println("empleat index " + i + " - " + jsonArrayVioleta.get(i));
                System.out.println("id: " + i + " - " + jsonArrayVioleta.getJSONObject(i).get("id"));
                System.out.println("nom: " + i + " - " + jsonArrayVioleta.getJSONObject(i).get("nom"));
                System.out.println("llinatge1: " + i + " - " + jsonArrayVioleta.getJSONObject(i).get("llinatge1"));
                System.out.println("llinatge2: " + i + " - " + jsonArrayVioleta.getJSONObject(i).get("llinatge2"));
                System.out.println("telefon: " + i + " - " + jsonArrayVioleta.getJSONObject(i).get("telefon"));

                System.out.println(jsonArrayVioleta.getJSONObject(i));
            }





            System.out.println();
            // ! matricula.json
            System.out.println("Matricula --> keySet(): " + jsonObject.keySet());
            System.out.println("Matricula --> length(): " + jsonObject.length());
            System.out.println("Matricula --> length(): " + jsonObject.length());

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
