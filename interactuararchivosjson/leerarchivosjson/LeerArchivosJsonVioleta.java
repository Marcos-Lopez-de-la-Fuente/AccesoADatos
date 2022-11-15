package interactuararchivosjson.leerarchivosjson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.*; // Librería importada localmente

public class LeerArchivosJsonVioleta {
    JSONObject jsonObject;
    JSONArray jsonArray;

    private static final String PATHFILEJSONVIOLETA = "./interactuararchivosjson/leerarchivosjson/institutoPruebasVioleta.json";

    public static void main(String[] args) {
        try {
            // Crear un String del archivo Json
            String stringFileJSONVioleta = new String(
                    Files.readAllBytes(Paths.get(LeerArchivosJsonVioleta.PATHFILEJSONVIOLETA)));

            // Convertir el String en un objeto "JSONObject"
            JSONObject jsonObjectVioleta = new JSONObject(stringFileJSONVioleta);

            // El método keySet() devuelve un Array de las claves en el primer nivel del
            // Json
            System.out.println("keySet(): " + jsonObjectVioleta.keySet());

            // El método length() devuelve el número de claves en el primer nivel del Json
            System.out.println("length(): " + jsonObjectVioleta.length());

            // Método getString() devuelve el valor de la "key" que le introduzcas (Solo
            // tipos String)
            System.out.println("getString(\"institut\"): " + jsonObjectVioleta.getString("institut"));

            // Método getJSONArray() devuelve un Array del valor de la "key" que le
            // introduzcas
            JSONArray jsonArrayVioleta = jsonObjectVioleta.getJSONArray("empleats");
            System.out.println("getJSONArray(): " + jsonArrayVioleta);

            // Podemos recorrer el array obtenido anteriormente
            for (int i = 0; i < jsonArrayVioleta.length(); i++) {
                System.out.println();

                // ! Devuelve el objeto entero con sus atributos
                System.out.println("empleat index " + i + " - " + jsonArrayVioleta.get(i));

                // ! Mediante el método "getJSONObject()" podremos indicar después una "key"
                // para que nos devuelva su "value"
                System.out.println("id: " + jsonArrayVioleta.getJSONObject(i).get("id"));
                System.out.println("nom: " + jsonArrayVioleta.getJSONObject(i).get("nom"));
                System.out.println("llinatge1: " + jsonArrayVioleta.getJSONObject(i).get("llinatge1"));
                System.out.println("llinatge2: " + jsonArrayVioleta.getJSONObject(i).get("llinatge2"));
                System.out.println("telefon: " + jsonArrayVioleta.getJSONObject(i).get("telefon"));
            }

            System.out.println();

            JSONArray jsonArrayVioletaAlumnes = jsonObjectVioleta.getJSONArray("alumnes");

            for (int i = 0; i < jsonArrayVioletaAlumnes.length(); i++) {
                System.out.println();

                System.out.println("alumne index " + i + " - " + jsonArrayVioletaAlumnes.get(i));

                System.out.println("id: " + jsonArrayVioletaAlumnes.getJSONObject(i).get("id"));
                System.out.println("nom: " + jsonArrayVioletaAlumnes.getJSONObject(i).get("nom"));
                System.out.println("llinatge1: " + jsonArrayVioletaAlumnes.getJSONObject(i).get("llinatge1"));
                System.out.println("llinatge2: " + jsonArrayVioletaAlumnes.getJSONObject(i).get("llinatge2"));
                System.out.println("telefon: " + jsonArrayVioletaAlumnes.getJSONObject(i).get("telefon"));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
