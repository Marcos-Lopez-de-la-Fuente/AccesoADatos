package interactuararchivosjson.leerarchivosjson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.*; // Librería importada localmente

public class LeerMatricula {
    JSONObject jsonObject;
    JSONArray jsonArray;

    private static final String PATHFILEJSON = "./interactuararchivosjson/leerarchivosjson/matricula.json";

    public static void main(String[] args) {
        try {
            // Crear un String del archivo Json
            String stringFileJSON = new String(
                    Files.readAllBytes(Paths.get(LeerMatricula.PATHFILEJSON)));

            // Convertir el String en un objeto "JSONObject"
            JSONObject jsonObject = new JSONObject(stringFileJSON);

            JSONObject cicleObject = jsonObject.getJSONObject("cicle");

            // El método keySet() devuelve un Array de las claves en el primer nivel del
            // Json
            System.out.println("keySet(): " + cicleObject.keySet());

            // El método length() devuelve el número de claves en el primer nivel del Json
            System.out.println("length(): " + cicleObject.length());

            // Método getString() devuelve el valor de la "key" que le introduzcas (Solo
            // tipos String)
            System.out.println("getString(\"tipus\"): " + cicleObject.getString("tipus"));
            System.out.println("getString(\"codi\"): " + cicleObject.getString("codi"));
            System.out.println("getString(\"sigles\"): " + cicleObject.getString("sigles"));
            System.out.println("getString(\"nom\"): " + cicleObject.getString("nom"));

            // Método getJSONArray() devuelve un Array del valor de la "key" que le
            // introduzcas
            JSONArray jsonArray = cicleObject.getJSONArray("cursos");
            System.out.println("getJSONArray(): " + jsonArray);

            System.out.println();
            System.out.println();
            System.out.println();
            // Podemos recorrer el array obtenido anteriormente
            for (int i = 0; i < jsonArray.length(); i++) {
                System.out.println();
                System.out.println();
                System.out.println();

                System.out.println("matricula index: " + i);

                System.out.println("id: " + jsonArray.getJSONObject(i).get("id"));

                JSONArray jsonArrayInto = jsonArray.getJSONObject(i).getJSONArray("moduls");
                for (int j = 0; j < jsonArrayInto.length(); j++) {
                    System.out.println();
                    System.out.println("modul index: " + j);

                    System.out.println("codi: " + jsonArrayInto.getJSONObject(j).get("codi"));
                    System.out.println("nom: " + jsonArrayInto.getJSONObject(j).get("nom"));
                    System.out.println("nombreHores: " + jsonArrayInto.getJSONObject(j).get("nombreHores"));
                }
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
